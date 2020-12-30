package me.Aqua_rel.HypixelBedwars.Game.Mechanics;

import me.Aqua_rel.HypixelBedwars.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FireballCooldown {
    ArrayList<Player> players = new ArrayList<>();
    private final Plugin plugin;

    public FireballCooldown(Plugin _plugin) {
        this.plugin = _plugin;
    }

    public void addPlayer(Player player) {
        players.add(player);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> players.remove(player), 10);
    }
}
