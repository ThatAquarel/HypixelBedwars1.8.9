package me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers;

import me.Aqua_rel.HypixelBedwars.ItemShop.Menus.QuickBuy;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MenuOpen implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.HIGH)
    public void openShop(PlayerInteractEntityEvent e) {
        //Bukkit.getServer().getConsoleSender().sendMessage("menu open");
        //Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(GetPlayerItem.countItem(e.getPlayer(),
        //        265)));
        //Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(GetPlayerItem.countItem(e.getPlayer(),
        //        266)));

        if (e.getRightClicked().getType() == EntityType.VILLAGER && e.getRightClicked().getName().equals("ItemShop")) {
            QuickBuy quickbuy = new QuickBuy();
            quickbuy.quickbuyInv(e.getPlayer());
            e.setCancelled(true);
        }
    }
}
