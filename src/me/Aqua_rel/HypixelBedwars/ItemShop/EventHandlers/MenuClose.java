package me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class MenuClose implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void closeShop(InventoryCloseEvent e) {
        if (!e.getInventory().getTitle().equals("container.chest") && !e.getInventory().getTitle().equals("container.enderchest") && !e.getInventory().getTitle().equals("container.inventory")) {
            //Bukkit.getServer().getConsoleSender().sendMessage("menu closed");
            e.getPlayer().setItemOnCursor(new ItemStack(Material.AIR));
        }
    }
}
