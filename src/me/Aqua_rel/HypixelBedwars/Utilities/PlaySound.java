package me.Aqua_rel.HypixelBedwars.Utilities;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlaySound {
    public static void eggPlop(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
    }
}
