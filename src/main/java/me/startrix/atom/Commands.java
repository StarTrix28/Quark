package me.startrix.atom;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (command.getName().equalsIgnoreCase("itemstack")) {
                if(p.isOp()){
                    p.sendMessage(String.valueOf(p.getInventory().getItemInMainHand().serialize()));
                    Bukkit.getConsoleSender().sendRawMessage(String.valueOf(p.getInventory().getItemInMainHand()));
                    Inventory inv = Bukkit.createInventory(p, InventoryType.STONECUTTER);
                    p.openInventory(inv);
                }
            }
        }
        return true;
    }
}
