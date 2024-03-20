package me.startrix.quark.quark.machines;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static me.startrix.quark.define.QuarkItemsDefine.CategoryAdvancedElectricity;
import static me.startrix.quark.define.QuarkItemsDefine.Cobble_Generator;

public final class StoneGenerator extends AContainer {
        public static final int TIME = 1;
        public StoneGenerator() {
            super(CategoryAdvancedElectricity,Cobble_Generator,new RecipeType(new CustomItemStack(Material.BARRIER,"Not yet implemented"),"notimplemented"),new ItemStack[]{});
        }
        protected void registerDefaultRecipes() {
            registerRecipe(1,null, new ItemStack(Material.STONE));
        }
        public ItemStack getProgressBar() {
            ItemStack pick = new ItemStack(Material.IRON_PICKAXE);pick.addEnchantment(Enchantment.SILK_TOUCH,1);
            return pick;
        }

        @Nonnull
        public String getInventoryTitle() {
            return "&6Stone Generator";
        }

        @Nonnull
        public String getMachineIdentifier() {
            return "STONE_GENERATOR";
        }

        public int getCapacity() {
            return this.getDefaultEnergyConsumption() * 5;
        }

        public int getDefaultEnergyConsumption() {return 60;}

        public int getEnergyConsumption() {
            return this.getDefaultEnergyConsumption();
        }

        public int getSpeed() {
            return 1;
        }
}
