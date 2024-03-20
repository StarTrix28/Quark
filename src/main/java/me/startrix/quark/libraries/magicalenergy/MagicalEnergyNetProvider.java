package me.startrix.quark.libraries.magicalenergy;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import org.bukkit.Location;

import javax.annotation.Nonnull;

public interface MagicalEnergyNetProvider extends MagicalEnergyNetComponent {
    @Nonnull
    default MagicalEnergyNetComponentType getEnergyComponentType() {
        return MagicalEnergyNetComponentType.GENERATOR;
    }

    int getGeneratedOutput(@Nonnull Location var1, @Nonnull Config var2);

    default boolean willExplode(@Nonnull Location l, @Nonnull Config data) {
        return false;
    }
}
