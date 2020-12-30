package me.Aqua_rel.HypixelBedwars.Game.Mechanics;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Enderpearl implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void enderpearlLand(PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
            e.setCancelled(true);
            Location tpLoc = e.getTo();

            if (tpLoc.getBlock().getType().equals(Material.AIR) && tpLoc.getBlock().getRelative(BlockFace.UP).getType().equals(Material.AIR)) {
                e.getPlayer().teleport(new Location(tpLoc.getWorld(), tpLoc.getX(), tpLoc.getY(), tpLoc.getZ(),
                        tpLoc.getYaw(), tpLoc.getPitch()));
            } else {
                e.getPlayer().teleport(e.getFrom());
            }
        }
    }
}
