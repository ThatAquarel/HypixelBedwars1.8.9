package me.Aqua_rel.HypixelBedwars.Bugfixes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BedClick implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void bedClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getClickedBlock().getType().name().equals("BED_BLOCK")){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void bedEnter(PlayerBedEnterEvent e) {
        e.setCancelled(true);
    }
}
