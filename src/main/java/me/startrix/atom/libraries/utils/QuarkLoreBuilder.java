package me.startrix.atom.libraries.utils;

import javax.annotation.Nonnull;

public class QuarkLoreBuilder {
    @Nonnull
    public static String speed(float speed) {
        return "&8⇨ &e\uD83E\uDE84 &7Speed: &b" + speed + "x";
    }

    @Nonnull
    public static String powerBuffer(int power) {
        return power(power, " Buffer");
    }

    @Nonnull
    public static String powerPerSecond(int power) {
        return power(power, "/s");
    }

    @Nonnull
    public static String power(int power, @Nonnull String suffix) {
        return "&8⇨ &e\uD83E\uDE84 &7" + power + " ME" + suffix;
    }

    @Nonnull
    public static String powerCharged(int charge, int capacity) {
        return "&8⇨ &e\uD83E\uDE84 &7" + charge + " / " + capacity + " ME";
    }
    public static String Stability(int unstableint) {
        String s = "&f&lHey, do it the right way! (0-6)";
        if (unstableint == 0) s = "&f&lStability: &a&l#####";
        else if (unstableint == 1) s = "&f&lStability: &4&l#&a&l####";
        else if (unstableint == 2) s = "&f&lStability: &4&l##&a&l###";
        else if (unstableint == 3) s = "&f&lStability: &4&l###&a&l##";
        else if (unstableint == 4) s = "&f&lStability: &4&l####&a&l#";
        else if (unstableint == 5) s = "&f&lStability: &4&l#####";
        else if (unstableint == 6) s = "&f&lStability: &4&lERROR";
        return s;
    }

}
