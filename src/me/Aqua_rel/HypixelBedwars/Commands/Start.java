package me.Aqua_rel.HypixelBedwars.Commands;

import me.Aqua_rel.HypixelBedwars.Game.Run.BlockEvents;
import me.Aqua_rel.HypixelBedwars.Game.Start.TeamSelector;
import me.Aqua_rel.HypixelBedwars.Game.Start.Teams;
import me.Aqua_rel.HypixelBedwars.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {
    private final Plugin plugin;
    private final Teams teams;
    public BlockEvents blockEvents;
    private boolean running = false;

    public Start(Plugin _plugin, Teams _teams) {
        this.plugin = _plugin;
        this.teams = _teams;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player invoker = (Player) sender;
        if (!this.running) {
            // Register Game Events
            blockEvents = new BlockEvents();
            this.plugin.getServer().getPluginManager().registerEvents(blockEvents, this.plugin);

            // Other
            this.running = true;

            //Team Selector
            for (Player player : Bukkit.getOnlinePlayers()) {
                TeamSelector teamSelector = new TeamSelector(plugin, teams);
                this.plugin.getServer().getPluginManager().registerEvents(teamSelector, plugin);

                player.openInventory(teamSelector.inv);
            }

            invoker.sendMessage(ChatColor.GREEN + "Game Started!");
        } else {
            invoker.sendMessage(ChatColor.RED + "Game Already Started!");
        }
        return true;
    }

    public void setRunning(Boolean state) {
        this.running = state;
    }

    public boolean getRunning() {
        return this.running;
    }
}
