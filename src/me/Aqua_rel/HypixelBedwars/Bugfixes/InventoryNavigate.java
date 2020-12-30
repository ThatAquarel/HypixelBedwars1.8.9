package me.Aqua_rel.HypixelBedwars.Bugfixes;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryNavigate implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void navigateShop(InventoryClickEvent e) {
        if (e.getClick() != ClickType.UNKNOWN && e.getClick() != null && e.getClickedInventory() != null) {
            if (e.getClickedInventory().getTitle().equals("container.inventory")) {
                //Bukkit.getConsoleSender().sendMessage(Bukkit.getPlayer(e.getWhoClicked().getUniqueId())
                // .getOpenInventory().getTitle());

                String title = Bukkit.getPlayer(e.getWhoClicked().getUniqueId()).getOpenInventory().getTitle();
                if (!title.equals("container.chest") && !title.equals("container.enderchest") && !title.equals(
                        "container.crafting")) {
                    e.setCancelled(true);
                }
            }
        }
    }
}