package me.startrix.quark.items.machines;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static me.startrix.quark.ItemsDefine.CategoryMachines;
import static me.startrix.quark.ItemsDefine.Cobble_Generator;

public final class StoneGenerator extends AContainer {
        public static final int TIME = 1;
        public StoneGenerator() {
            super(CategoryMachines,Cobble_Generator, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{new ItemStack(Material.REDSTONE), new ItemStack(Material.REDSTONE), new ItemStack(Material.REDSTONE), new ItemStack(Material.COBBLESTONE),null, new ItemStack(Material.COBBLESTONE), null,null, null});
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
