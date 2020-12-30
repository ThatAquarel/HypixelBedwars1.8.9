package me.Aqua_rel.HypixelBedwars.Game.Mechanics;

import me.Aqua_rel.HypixelBedwars.Commands.Start;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Tnts implements Listener {
    private final Start start;

    public Tnts(Start _start) {
        this.start = _start;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void tntPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.TNT)) {
            e.getBlock().setType(Material.AIR);
            TNTPrimed tntPrimed = e.getBlock().getWorld().spawn(new Location(e.getBlock().getWorld(),
                    e.getBlock().getX() + 0.5,
                    e.getBlock().getY() + 0.5,
                    e.getBlock().getZ() + 0.5), TNTPrimed.class);

            tntPrimed.setFuseTicks(50);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void tntDamageEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType().equals(EntityType.PRIMED_TNT)) {
            e.setDamage(2);
            if (e.getEntity().getType().equals(EntityType.PLAYER)) {
                Player player = (Player) e.getEntity();
                player.setVelocity(player.getLocation().getDirection().multiply(1.5).add(new Vector(0, 0.5, 0)));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void tntBlow(EntityExplodeEvent e) {
        if (e.getEntity().getType().equals(EntityType.PRIMED_TNT)) {
            List<Block> blockList = e.blockList();
            List<Block> mapBlocks = new ArrayList<>();

            for (Block _block : blockList) {
                if (!start.blockEvents.getPlacedBlocks().contains(_block)) {
                    mapBlocks.add(_block);
                }
            }
            for (Block _block : mapBlocks) {
                blockList.remove(_block);
            }
        }
    }
}
