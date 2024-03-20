package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.api.ErrorReport;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.network.Network;
import io.github.thebusybiscuit.slimefun4.api.network.NetworkComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.HologramOwner;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongConsumer;

import static me.startrix.quark.define.QuarkMagicalItemsDefine.Magical_Energy_Regulator;

public class MagicalEnergyNet extends Network implements HologramOwner {
    private static final int RANGE = 6;
    private final Map<Location, MagicalEnergyNetProvider> generators = new HashMap();
    private final Map<Location, MagicalEnergyNetComponent> capacitors = new HashMap();
    private final Map<Location, MagicalEnergyNetComponent> consumers = new HashMap();

    protected MagicalEnergyNet(@Nonnull Location l) {
        super(Slimefun.getNetworkManager(), l);
    }

    public int getRange() {
        return 6;
    }

    @Nonnull
    public Map<Location, MagicalEnergyNetProvider> getGenerators() {
        return Collections.unmodifiableMap(this.generators);
    }

    @Nonnull
    public Map<Location, MagicalEnergyNetComponent> getCapacitors() {
        return Collections.unmodifiableMap(this.capacitors);
    }

    @Nonnull
    public Map<Location, MagicalEnergyNetComponent> getConsumers() {
        return Collections.unmodifiableMap(this.consumers);
    }

    @Nonnull
    public String getId() {
        return "MAGICAL_ENERGY_NETWORK";
    }

    public NetworkComponent classifyLocation(@Nonnull Location l) {
        if (this.regulator.equals(l)) {
            return NetworkComponent.REGULATOR;
        } else {
            MagicalEnergyNetComponent component = getComponent(l);
            if (component == null) {
                return null;
            } else {
                NetworkComponent var10000;
                switch (component.getEnergyComponentType()) {
                    case CONNECTOR:
                    case CAPACITOR:
                        var10000 = NetworkComponent.CONNECTOR;
                        break;
                    case CONSUMER:
                    case GENERATOR:
                        var10000 = NetworkComponent.TERMINUS;
                        break;
                    default:
                        var10000 = null;
                }

                return var10000;
            }
        }
    }

    public void onClassificationChange(Location l, NetworkComponent from, NetworkComponent to) {
        if (from == NetworkComponent.TERMINUS) {
            this.generators.remove(l);
            this.consumers.remove(l);
        }

        MagicalEnergyNetComponent component = getComponent(l);
        if (component != null) {
            switch (component.getEnergyComponentType()) {
                case CAPACITOR:
                    this.capacitors.put(l, component);
                    break;
                case CONSUMER:
                    this.consumers.put(l, component);
                    break;
                case GENERATOR:
                    if (component instanceof MagicalEnergyNetProvider) {
                        MagicalEnergyNetProvider provider = (MagicalEnergyNetProvider)component;
                        this.generators.put(l, provider);
                    } else if (component instanceof SlimefunItem) {
                        SlimefunItem item = (SlimefunItem)component;
                        item.warn("This Item is marked as a GENERATOR but does not implement the interface MagicalEnergyNetProvider!");
                    }
            }
        }

    }

    public void tick(@Nonnull Block b) {
        AtomicLong timestamp = new AtomicLong(Slimefun.getProfiler().newEntry());
        if (!this.regulator.equals(b.getLocation())) {
            this.updateHologram(b, "&4Multiple Energy Regulators connected");
            Slimefun.getProfiler().closeEntry(b.getLocation(), Magical_Energy_Regulator.getItem(), timestamp.get());
        } else {
            super.tick();
            if (this.connectorNodes.isEmpty() && this.terminusNodes.isEmpty()) {
                this.updateHologram(b, "&4No Energy Network found");
            } else {
                Objects.requireNonNull(timestamp);
                int generatorsSupply = this.tickAllGenerators(timestamp::getAndAdd);
                int capacitorsSupply = this.tickAllCapacitors();
                int supply = NumberUtils.flowSafeAddition(generatorsSupply, capacitorsSupply);
                int remainingEnergy = supply;
                int demand = 0;
                Iterator var8 = this.consumers.entrySet().iterator();

                while(var8.hasNext()) {
                    Map.Entry<Location, MagicalEnergyNetComponent> entry = (Map.Entry)var8.next();
                    Location loc = (Location)entry.getKey();
                    MagicalEnergyNetComponent component = (MagicalEnergyNetComponent)entry.getValue();
                    int capacity = component.getCapacity();
                    int charge = component.getCharge(loc);
                    if (charge < capacity) {
                        int availableSpace = capacity - charge;
                        demand = NumberUtils.flowSafeAddition(demand, availableSpace);
                        if (remainingEnergy > 0) {
                            if (remainingEnergy > availableSpace) {
                                component.setCharge(loc, capacity);
                                remainingEnergy -= availableSpace;
                            } else {
                                component.setCharge(loc, charge + remainingEnergy);
                                remainingEnergy = 0;
                            }
                        }
                    }
                }

                this.storeRemainingEnergy(remainingEnergy);
                this.updateHologram(b, (double)supply, (double)demand);
            }

            Slimefun.getProfiler().closeEntry(b.getLocation(), Magical_Energy_Regulator.getItem(), timestamp.get());
        }
    }

    private void storeRemainingEnergy(int remainingEnergy) {
        Iterator var2 = this.capacitors.entrySet().iterator();

        Map.Entry entry;
        Location loc;
        int capacity;
        while(var2.hasNext()) {
            entry = (Map.Entry)var2.next();
            loc = (Location)entry.getKey();
            MagicalEnergyNetComponent component = (MagicalEnergyNetComponent)entry.getValue();
            if (remainingEnergy > 0) {
                capacity = component.getCapacity();
                if (remainingEnergy > capacity) {
                    component.setCharge(loc, capacity);
                    remainingEnergy -= capacity;
                } else {
                    component.setCharge(loc, remainingEnergy);
                    remainingEnergy = 0;
                }
            } else {
                component.setCharge(loc, 0);
            }
        }

        var2 = this.generators.entrySet().iterator();

        while(var2.hasNext()) {
            entry = (Map.Entry)var2.next();
            loc = (Location)entry.getKey();
            MagicalEnergyNetProvider component = (MagicalEnergyNetProvider)entry.getValue();
            capacity = component.getCapacity();
            if (remainingEnergy > 0) {
                if (remainingEnergy > capacity) {
                    component.setCharge(loc, capacity);
                    remainingEnergy -= capacity;
                } else {
                    component.setCharge(loc, remainingEnergy);
                    remainingEnergy = 0;
                }
            } else {
                component.setCharge(loc, 0);
            }
        }

    }

    private int tickAllGenerators(@Nonnull LongConsumer timings) {
        Set<Location> explodedBlocks = new HashSet();
        int supply = 0;
        Iterator var4 = this.generators.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<Location, MagicalEnergyNetProvider> entry = (Map.Entry)var4.next();
            long timestamp = Slimefun.getProfiler().newEntry();
            Location loc = (Location)entry.getKey();
            MagicalEnergyNetProvider provider = (MagicalEnergyNetProvider)entry.getValue();
            SlimefunItem item = (SlimefunItem)provider;

            try {
                Config data = BlockStorage.getLocationInfo(loc);
                int energy = provider.getGeneratedOutput(loc, data);
                if (provider.isChargeable()) {
                    energy = NumberUtils.flowSafeAddition(energy, provider.getCharge(loc, data));
                }

                if (provider.willExplode(loc, data)) {
                    explodedBlocks.add(loc);
                    BlockStorage.clearBlockInfo(loc);
                    Slimefun.runSync(() -> {
                        loc.getBlock().setType(Material.LAVA);
                        loc.getWorld().createExplosion(loc, 0.0F, false);
                    });
                } else {
                    supply = NumberUtils.flowSafeAddition(supply, energy);
                }
            } catch (LinkageError | Exception var13) {
                explodedBlocks.add(loc);
                new ErrorReport(var13, loc, item);
            }

            long time = Slimefun.getProfiler().closeEntry(loc, item, timestamp);
            timings.accept(time);
        }

        if (!explodedBlocks.isEmpty()) {
            this.generators.keySet().removeAll(explodedBlocks);
        }

        return supply;
    }

    private int tickAllCapacitors() {
        int supply = 0;

        Map.Entry entry;
        for(Iterator var2 = this.capacitors.entrySet().iterator(); var2.hasNext(); supply = NumberUtils.flowSafeAddition(supply, ((MagicalEnergyNetComponent)entry.getValue()).getCharge((Location)entry.getKey()))) {
            entry = (Map.Entry)var2.next();
        }

        return supply;
    }

    private void updateHologram(@Nonnull Block b, double supply, double demand) {
        String netLoss;
        if (demand > supply) {
            netLoss = NumberUtils.getCompactDouble(demand - supply);
            this.updateHologram(b, "&4&l- &c" + netLoss + " &7J &e⚡");
        } else {
            netLoss = NumberUtils.getCompactDouble(supply - demand);
            this.updateHologram(b, "&2&l+ &a" + netLoss + " &7J &e⚡");
        }

    }

    @Nullable
    private static MagicalEnergyNetComponent getComponent(@Nonnull Location l) {
        SlimefunItem item = BlockStorage.check(l);
        if (item instanceof MagicalEnergyNetComponent component) {
            return component;
        } else {
            return null;
        }
    }

    @Nullable
    public static MagicalEnergyNet getNetworkFromLocation(@Nonnull Location l) {
        return (MagicalEnergyNet)Slimefun.getNetworkManager().getNetworkFromLocation(l, MagicalEnergyNet.class).orElse((MagicalEnergyNet) null);
    }

    @Nonnull
    public static MagicalEnergyNet getNetworkFromLocationOrCreate(@Nonnull Location l) {
        Optional<MagicalEnergyNet> energyNetwork = Slimefun.getNetworkManager().getNetworkFromLocation(l, MagicalEnergyNet.class);
        if (energyNetwork.isPresent()) {
            return (MagicalEnergyNet)energyNetwork.get();
        } else {
            MagicalEnergyNet network = new MagicalEnergyNet(l);
            Slimefun.getNetworkManager().registerNetwork(network);
            return network;
        }
    }
}
