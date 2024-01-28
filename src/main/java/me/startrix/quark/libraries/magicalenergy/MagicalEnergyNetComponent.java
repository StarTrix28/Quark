package me.startrix.quark.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.core.attributes.ItemAttribute;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.blocks.BlockPosition;
import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;

import javax.annotation.Nonnull;
import java.util.logging.Level;

public interface MagicalEnergyNetComponent extends ItemAttribute {
    @Nonnull
    MagicalEnergyNetComponentType getEnergyComponentType();

    int getCapacity();

    default boolean isChargeable() {
        return this.getCapacity() > 0;
    }

    default int getCharge(@Nonnull Location l) {
        return !this.isChargeable() ? 0 : this.getCharge(l, BlockStorage.getLocationInfo(l));
    }

    default int getCharge(@Nonnull Location l, @Nonnull Config data) {
        Validate.notNull(l, "Location was null!");
        Validate.notNull(data, "data was null!");
        if (!this.isChargeable()) {
            return 0;
        } else {
            String charge = data.getString("magicenergy-charge");
            return charge != null ? Integer.parseInt(charge) : 0;
        }
    }

    default void setCharge(@Nonnull Location l, int charge) {
        Validate.notNull(l, "Location was null!");
        Validate.isTrue(charge >= 0, "You can only set a charge of zero or more!");

        try {
            int capacity = this.getCapacity();
            if (capacity > 0) {
                charge = NumberUtils.clamp(0, charge, capacity);
                if (charge != this.getCharge(l)) {
                    BlockStorage.addBlockInfo(l, "magicenergy-charge", String.valueOf(charge), false);
                    if (this.getEnergyComponentType() == MagicalEnergyNetComponentType.CAPACITOR) {
                        SlimefunUtils.updateCapacitorTexture(l, charge, capacity);
                    }
                }
            }
        } catch (LinkageError | Exception var4) {
            Slimefun.logger().log(Level.SEVERE, var4, () -> {
                String var10000 = this.getId();
                return "Exception while trying to set the magicenergy-charge for \"" + var10000 + "\" at " + new BlockPosition(l);
            });
        }

    }

    default void addCharge(@Nonnull Location l, int charge) {
        Validate.notNull(l, "Location was null!");
        Validate.isTrue(charge > 0, "You can only add a positive charge!");

        try {
            int capacity = this.getCapacity();
            if (capacity > 0) {
                int currentCharge = this.getCharge(l);
                if (currentCharge < capacity) {
                    int newCharge = Math.min(capacity, currentCharge + charge);
                    BlockStorage.addBlockInfo(l, "magicenergy-charge", String.valueOf(newCharge), false);
                    if (this.getEnergyComponentType() == MagicalEnergyNetComponentType.CAPACITOR) {
                        SlimefunUtils.updateCapacitorTexture(l, charge, capacity);
                    }
                }
            }
        } catch (LinkageError | Exception var6) {
            Slimefun.logger().log(Level.SEVERE, var6, () -> {
                String var10000 = this.getId();
                return "Exception while trying to add an magicenergy-charge for \"" + var10000 + "\" at " + new BlockPosition(l);
            });
        }

    }

    default void removeCharge(@Nonnull Location l, int charge) {
        Validate.notNull(l, "Location was null!");
        Validate.isTrue(charge > 0, "The charge to remove must be greater than zero!");

        try {
            int capacity = this.getCapacity();
            if (capacity > 0) {
                int currentCharge = this.getCharge(l);
                if (currentCharge > 0) {
                    int newCharge = Math.max(0, currentCharge - charge);
                    BlockStorage.addBlockInfo(l, "magicenergy-charge", String.valueOf(newCharge), false);
                    if (this.getEnergyComponentType() == MagicalEnergyNetComponentType.CAPACITOR) {
                        SlimefunUtils.updateCapacitorTexture(l, charge, capacity);
                    }
                }
            }
        } catch (LinkageError | Exception var6) {
            Slimefun.logger().log(Level.SEVERE, var6, () -> {
                String var10000 = this.getId();
                return "Exception while trying to remove an magicenergy-charge for \"" + var10000 + "\" at " + new BlockPosition(l);
            });
        }

    }
}
