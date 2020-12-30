package me.Aqua_rel.HypixelBedwars.Commands;

import me.Aqua_rel.HypixelBedwars.Game.End.ReplaceBeds;
import me.Aqua_rel.HypixelBedwars.Game.Start.Teams;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Reset implements CommandExecutor {
    private final Start start;
    private final Teams teams;

    public Reset(Start _start, Teams _teams) {
        this.start = _start;
        this.teams = _teams;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player invoker = (Player) sender;
        if (start.getRunning()) {
            // Unregister Game Events

            BlockPlaceEvent.getHandlerList().unregister(this.start.blockEvents);
            BlockBreakEvent.getHandlerList().unregister(this.start.blockEvents);

            // Clear Placed Blocks
            this.start.blockEvents.clearBlocks();

            // Reset Beds
            ReplaceBeds.replaceBeds();

            //Other
            start.setRunning(false);

            //Teams
            this.teams.red.clear();
            this.teams.blue.clear();
            this.teams.green.clear();
            this.teams.yellow.clear();
            this.teams.spec.clear();

//        Maps.players.clear();
//
//        Maps.sharpness.clear();
//        Maps.protection.clear();
//        Maps.haste.clear();
//        Maps.forge.clear();
//        Maps.dragon.clear();
//        Maps.trap.clear();
//
//        Maps.armor.clear();
//        Maps.pick.clear();
//        Maps.axe.clear();
//        Maps.shears.clear();

            invoker.sendMessage(ChatColor.GREEN + "Game Stopped!");
        } else {
            invoker.sendMessage(ChatColor.RED + "Game Not Stated Yet!");
        }
        return true;
    }
}
