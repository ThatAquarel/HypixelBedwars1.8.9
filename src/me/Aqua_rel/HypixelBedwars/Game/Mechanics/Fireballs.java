package me.Aqua_rel.HypixelBedwars.Game.Mechanics;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Fireballs implements Listener {
    private final FireballCooldown fireballCooldown;

    public Fireballs(FireballCooldown _fireballCooldown) {
        this.fireballCooldown = _fireballCooldown;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void throwFireball(PlayerInteractEvent e) {
        Action action = e.getAction();
        if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_AIR)) {
            if (e.getPlayer().getItemInHand().getType().equals(Material.FIREBALL)) {
                if (!fireballCooldown.players.contains(e.getPlayer())) {
                    Location eyeLocation = e.getPlayer().getEyeLocation().subtract(0, 0.5, 0);
                    Vector vector = e.getPlayer().getLocation().getDirection().multiply(1.5);
                    Location location = eyeLocation.add(vector);

                    Entity fireball = location.getWorld().spawnEntity(location,
                            EntityType.FIREBALL);
                    fireball.setVelocity(location.getDirection().multiply(0.5));

                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 1, false));

                    fireballCooldown.addPlayer(e.getPlayer());
                }else{
                    e.getPlayer().sendMessage(ChatColor.RED + "Please wait 0.5s to use that again");
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void fireballExplode(ProjectileHitEvent e) {
        if (e.getEntityType().equals(EntityType.FIREBALL)) {
            TNTPrimed tntPrimed = e.getEntity().getLocation().getWorld().spawn(new Location(e.getEntity().getLocation().getWorld(),
                    e.getEntity().getLocation().getX(),
                    e.getEntity().getLocation().getY(),
                    e.getEntity().getLocation().getZ()), TNTPrimed.class);

            tntPrimed.setYield(2F);
            tntPrimed.setIsIncendiary(true);
            tntPrimed.setFuseTicks(0);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void fireballDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType().equals(EntityType.FIREBALL)) {
            e.setDamage(0);
        }
        if (e.getDamager().getType().equals(EntityType.PRIMED_TNT)) {
            if (e.getDamager().getTicksLived() < 5) {
                e.setDamage(2);
            }
        }
    }
}
