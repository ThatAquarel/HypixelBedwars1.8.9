package me.Aqua_rel.HypixelBedwars.Bugfixes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class InventoryCrafting implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void invClick(InventoryClickEvent e) {
        if (e.getClick() != ClickType.UNKNOWN && e.getClick() != null && e.getClickedInventory() != null) {
            //Bukkit.getConsoleSender().sendMessage(e.getClickedInventory().getTitle());
            //Bukkit.getConsoleSender().sendMessage(String.valueOf(e.getSlot()));
            //Bukkit.getConsoleSender().sendMessage(e.getClick().toString());

            if (e.getClickedInventory().getTitle().equals("container.crafting")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void invDrag(InventoryDragEvent e) {
        if (e.getInventory() != null) {
            //Bukkit.getConsoleSender().sendMessage("drag");
            //Bukkit.getConsoleSender().sendMessage(e.getRawSlots().toString());
            //Bukkit.getConsoleSender().sendMessage(e.getInventory().getTitle());

            if (e.getInventory().getTitle().equals("container.crafting")) {
                for (Integer slot : e.getRawSlots()) {
                    if (slot > 0 && slot < 5) {
                        //Bukkit.getConsoleSender().sendMessage("canceled");

                        e.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void craftClick(CraftItemEvent e) {
        //Bukkit.getConsoleSender().sendMessage("CraftItem");

        e.setCancelled(true);
    }
}
