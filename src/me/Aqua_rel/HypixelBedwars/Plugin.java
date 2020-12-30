package me.Aqua_rel.HypixelBedwars;

import me.Aqua_rel.HypixelBedwars.Bugfixes.BedClick;
import me.Aqua_rel.HypixelBedwars.Bugfixes.DropBedItem;
import me.Aqua_rel.HypixelBedwars.Bugfixes.InventoryCrafting;
import me.Aqua_rel.HypixelBedwars.Bugfixes.InventoryNavigate;
import me.Aqua_rel.HypixelBedwars.Commands.Reset;
import me.Aqua_rel.HypixelBedwars.Commands.Start;
import me.Aqua_rel.HypixelBedwars.Game.Mechanics.*;
import me.Aqua_rel.HypixelBedwars.Game.Start.Teams;
import me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers.BuyItem;
import me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers.MenuClose;
import me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers.MenuNavigate;
import me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers.MenuOpen;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Register Commands

        Teams teams = new Teams();
        Start start = new Start(this, teams);
        this.getCommand("bwstart").setExecutor(start);
        this.getCommand("bwreset").setExecutor(new Reset(start, teams));

        // Register ItemShop Events
        getServer().getPluginManager().registerEvents(new MenuOpen(), this);
        getServer().getPluginManager().registerEvents(new MenuNavigate(), this);
        getServer().getPluginManager().registerEvents(new MenuClose(), this);
        getServer().getPluginManager().registerEvents(new BuyItem(), this);

        // Register UpgradeShop Events


        // Register Game Events

        // Register Item Mechanics Events
        getServer().getPluginManager().registerEvents(new Tnts(start), this);
        FireballCooldown fireballCooldown = new FireballCooldown(this);
        getServer().getPluginManager().registerEvents(new Fireballs(fireballCooldown), this);
        getServer().getPluginManager().registerEvents(new BridgeEgg(this, start), this);
        getServer().getPluginManager().registerEvents(new Enderpearl(), this);
        getServer().getPluginManager().registerEvents(new Bedbug(), this);
        getServer().getPluginManager().registerEvents(new PopupTower(this, start), this);

        // Register Bugfix Events
        getServer().getPluginManager().registerEvents(new InventoryNavigate(), this);
        getServer().getPluginManager().registerEvents(new InventoryCrafting(), this);
        getServer().getPluginManager().registerEvents(new BedClick(), this);
        getServer().getPluginManager().registerEvents(new DropBedItem(), this);

        // Debug
        getServer().getPluginManager().registerEvents(this, this);

        // Set Gamerules
        Bukkit.getWorld("world").setGameRuleValue("doDaylightCycle", "false");
        Bukkit.getWorld("world").setGameRuleValue("doWeatherCycle", "false");
        Bukkit.getWorld("world").setGameRuleValue("doMobSpawning", "false");
        Bukkit.getWorld("world").setGameRuleValue("doFireTick", "false");
        Bukkit.getWorld("world").setGameRuleValue("mobGriefing", "false");
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void stopOnLeave(PlayerQuitEvent e) {
        Bukkit.getServer().shutdown();
    }
}