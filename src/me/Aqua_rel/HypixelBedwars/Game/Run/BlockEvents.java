package me.Aqua_rel.HypixelBedwars.Game.Run;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class BlockEvents implements Listener {
    ArrayList<Block> placedBlocks = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void placeBlock(BlockPlaceEvent e) {
        //Bukkit.getConsoleSender().sendMessage("Block Placed");

        placedBlocks.add(e.getBlock());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void breakBlock(BlockBreakEvent e) {
        if (!placedBlocks.contains(e.getBlock())) {
            if (!e.getBlock().getType().equals(Material.BED_BLOCK)) {
                e.getPlayer().sendMessage(ChatColor.RED + "You can't break blocks here!");
                e.setCancelled(true);
            }
        } else {
            placedBlocks.remove(e.getBlock());
        }
    }

    public void addBlock(Block block) {
        placedBlocks.add(block);
    }

    public void removeBlock(Block block) {
        placedBlocks.remove(block);
    }

    public void clearBlocks() {
        for (Block block : placedBlocks) {
            block.setType(Material.AIR);
        }
        placedBlocks.clear();
    }

    public ArrayList<Block> getPlacedBlocks() {
        return placedBlocks;
    }
}
