package me.startrix.atom.items.energy;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.Optional;

import static me.startrix.atom.ItemsDefine.CategoryTechnicalGear;
public class EnergyRod extends SlimefunItem implements Rechargeable {
    private final int capacity;


    public EnergyRod(int capacity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(CategoryTechnicalGear, item, recipeType, recipe);
        this.capacity = capacity;
    }

    @Override
    public void preRegister() {
        ItemUseHandler h1 = this::RightClick;
        this.addItemHandler(h1);
    }

    private void RightClick(PlayerRightClickEvent event) {
        Optional<SlimefunItem> block = event.getSlimefunBlock();
        if (event.getClickedBlock().isPresent() && block.isPresent()) {
            SlimefunItem item = block.get();
            if (item instanceof EnergyNetComponent) {
                EnergyNetComponent component = (EnergyNetComponent) item;
                if (component.isChargeable()) {
                    event.cancel();
                    Location l = event.getClickedBlock().get().getLocation();
                    int capacitorCharge = component.getCharge(l);
                    int capacitorCapacity = component.getCapacity();
                    int capacitorAvailable = capacitorCapacity - capacitorCharge;
                    int WandCharge = (int) this.getItemCharge(event.getItem());
                    int WandAvailable = this.capacity - WandCharge;
                    if (component.getEnergyComponentType().equals(EnergyNetComponentType.CAPACITOR)) {
                        if(!(WandAvailable < 0) && !(capacitorAvailable < 0)) {
                            if (event.getPlayer().isSneaking()) {
                                if (capacitorCharge >= WandAvailable) {
                                    this.addItemCharge(event.getItem(), WandAvailable);
                                    component.removeCharge(l, WandAvailable);
                                } else {
                                    if (!(WandCharge == 0)) {
                                        this.addItemCharge(event.getItem(), capacitorCharge);
                                        component.removeCharge(l, capacitorCharge);
                                    }
                                }

                            } else {
                                if (WandCharge >= capacitorAvailable) {
                                    component.addCharge(l, capacitorAvailable);
                                    this.removeItemCharge(event.getItem(), capacitorAvailable);
                                } else {
                                    component.addCharge(l, WandCharge);
                                    this.removeItemCharge(event.getItem(), WandCharge);
                                }

                            }
                        }
                    } else {event.getPlayer().sendMessage("This is not capacitor");}
                }
            }
        }
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return this.capacity;
    }
}
