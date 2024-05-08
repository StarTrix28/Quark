package me.startrix.quark.quarkmagic.items.time;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.EntityInteractHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Objects;

import static me.startrix.quark.quarkmagic.QuarkMagicalItemsDefine.CategoryMagic;

public class TimeSword extends SlimefunItem {
    public TimeSword() {
        super(CategoryMagic, QuarkMagicalItemsDefine.TimeSword, RecipeType.NULL,new ItemStack[]{null});
    }

    @Override
    public void preRegister() {
        super.preRegister();
        addItemHandler(RightClick());
        ItemUseHandler h1 = this::RightClickAir;
        addItemHandler(h1);
    }
    private void rightclickcheck(Entity entity) {
        if (entity.getType().equals(EntityType.CREEPER)) {
            ((Creeper) entity).setFuseTicks(40);
        } else if(entity.getType().equals(EntityType.PRIMED_TNT)) {
            ((TNTPrimed)entity).setFuseTicks(120);
        }
        if(!(entity.getType().equals(EntityType.DROPPED_ITEM))) {
            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 255, true, false));
            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 255, true, false));
            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 255, true, false));
        }
    }
    private void RightClickAir(PlayerRightClickEvent e) {
        List<Entity> nearbye = e.getPlayer().getNearbyEntities(5,5,5);
        for(Entity entity:nearbye){
            if ((entity.getType().equals(EntityType.PLAYER))) {
                if (!(Objects.requireNonNull(((Player) entity).getEquipment()).getItemInOffHand().equals(QuarkMagicalItemsDefine.TimeStableClock))) {
                    rightclickcheck(entity);
                }
            } else {rightclickcheck(entity);}
        }
    }
    public ItemHandler RightClick() {
        return (EntityInteractHandler) (e, itemStack, b) -> {
            List<Entity> nearbye = e.getPlayer().getNearbyEntities(5,5,5);
            for(Entity entity:nearbye){
                if ((entity.getType().equals(EntityType.PLAYER))) {
                    if (!(Objects.requireNonNull(((Player) entity).getEquipment()).getItemInOffHand().equals(QuarkMagicalItemsDefine.TimeStableClock))) {
                        rightclickcheck(entity);
                    }
                } else {rightclickcheck(entity);}
            }
            if ((e.getRightClicked().getType().equals(EntityType.PLAYER))) {
                if (!(Objects.requireNonNull(((Player) e.getRightClicked()).getEquipment()).getItemInOffHand().equals(QuarkMagicalItemsDefine.TimeStableClock))) {
                    rightclickcheck(e.getRightClicked());
                }
            } else {rightclickcheck(e.getRightClicked());}
        };
    }

}
