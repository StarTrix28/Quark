package me.startrix.atom.libraries.magicalenergy;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.utils.PatternUtils;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class MagicalChargeUtils {
    private static final String LORE_PREFIX = ChatColors.color("&8⇨ &e\uD83E\uDE84 &7");
    private static final Pattern REGEX;

    private MagicalChargeUtils() {
    }

    public static void setCharge(@Nonnull ItemMeta meta, float charge, float capacity) {
        Validate.notNull(meta, "Meta cannot be null!");
        Validate.isTrue(charge >= 0.0F, "Charge has to be equal to or greater than 0!");
        Validate.isTrue(capacity > 0.0F, "Capacity has to be greater than 0!");
        Validate.isTrue(charge <= capacity, "Charge may not be bigger than the capacity!");
        BigDecimal decimal = BigDecimal.valueOf((double)charge).setScale(2, RoundingMode.HALF_UP);
        float value = decimal.floatValue();
        NamespacedKey key = Slimefun.getRegistry().getItemChargeDataKey();
        meta.getPersistentDataContainer().set(key, PersistentDataType.FLOAT, value);
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList();

        for(int i = 0; i < ((List)lore).size(); ++i) {
            String line = (String)((List)lore).get(i);
            if (REGEX.matcher(line).matches()) {
                ((List)lore).set(i, LORE_PREFIX + value + " / " + capacity + " ME");
                meta.setLore((List)lore);
                return;
            }
        }

        ((List)lore).add(LORE_PREFIX + value + " / " + capacity + " ME");
        meta.setLore((List)lore);
    }

    public static float getCharge(@Nonnull ItemMeta meta) {
        Validate.notNull(meta, "Meta cannot be null!");
        NamespacedKey key = Slimefun.getRegistry().getItemChargeDataKey();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        Float value = (Float)container.get(key, PersistentDataType.FLOAT);
        if (value != null) {
            return value;
        } else {
            if (meta.hasLore()) {
                Iterator var4 = meta.getLore().iterator();

                while(var4.hasNext()) {
                    String line = (String)var4.next();
                    if (REGEX.matcher(line).matches()) {
                        String data = ChatColor.stripColor(PatternUtils.SLASH_SEPARATOR.split(line)[0].replace(LORE_PREFIX, ""));
                        float loreValue = Float.parseFloat(data);
                        container.set(key, PersistentDataType.FLOAT, loreValue);
                        return loreValue;
                    }
                }
            }

            return 0.0F;
        }
    }

    static {
        REGEX = Pattern.compile(ChatColors.color("(&c&o)?" + LORE_PREFIX) + "[0-9.]+ / [0-9.]+ ME");
    }
}
