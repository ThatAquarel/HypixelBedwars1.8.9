package me.Aqua_rel.HypixelBedwars.Game.Mechanics;

import me.Aqua_rel.HypixelBedwars.Commands.Start;
import me.Aqua_rel.HypixelBedwars.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;

import java.util.ArrayList;

public class BridgeEgg implements Listener {
    ArrayList<Egg> eggs = new ArrayList<>();
    ArrayList<BlockFace> blockFaces = new ArrayList<>();
    private final Plugin plugin;

    public BridgeEgg(Plugin _plugin, Start start) {
        this.plugin = _plugin;

        blockFaces.add(BlockFace.NORTH);
        blockFaces.add(BlockFace.SOUTH);
        blockFaces.add(BlockFace.EAST);
        blockFaces.add(BlockFace.WEST);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Egg egg : eggs) {
                Location location = egg.getLocation();
                Block block = location.getBlock();

                if (block.getType().equals(Material.AIR)) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for (BlockFace blockFace : BlockFace.values()) {
                            if (blockFaces.contains(blockFace)) {
                                Block relativeBlock = block.getRelative(blockFace);
                                if (relativeBlock.getType().equals(Material.AIR) && relativeBlock.getRelative(BlockFace.UP).getType().equals(Material.AIR) && relativeBlock.getRelative(BlockFace.UP).getType().equals(Material.AIR)) {
                                    relativeBlock.setType(Material.WOOL);
                                    start.blockEvents.addBlock(relativeBlock);
                                }
                            }
                        }
                        start.blockEvents.addBlock(block);
                        block.setType(Material.WOOL);
                    }, 5L);
                }
            }
        }, 0L, 1L);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void throwEgg(PlayerEggThrowEvent e) {
        eggs.remove(e.getEgg());
        e.setHatching(false);
    }

    @SuppressWarnings("RedundantCast")
    @EventHandler(priority = EventPriority.HIGH)
    public void throwEgg(ProjectileLaunchEvent e) {
        if (e.getEntity() instanceof Egg) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> eggs.add((Egg) e.getEntity()), 4L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> eggs.remove((Egg) e.getEntity()), 30L);
        }
    }
}
