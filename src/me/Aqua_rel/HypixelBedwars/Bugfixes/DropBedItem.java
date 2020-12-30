package me.Aqua_rel.HypixelBedwars.Bugfixes;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DropBedItem implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void bedBreakPlayer(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.BED_BLOCK)) {
            //Bukkit.getConsoleSender().sendMessage("bedblock");

            e.setCancelled(true);

            BlockFace[] blockFaces = {BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST};
            for (BlockFace blockFace : blockFaces) {
                if (e.getBlock().getRelative(blockFace).getType().equals(Material.BED_BLOCK)) {
                    e.getBlock().getRelative(blockFace).setType(Material.AIR, false);

                    //Bukkit.getConsoleSender().sendMessage("Cleared" + blockFace.toString());
                }
            }

            e.getBlock().setType(Material.AIR, false);
        }
    }
}
