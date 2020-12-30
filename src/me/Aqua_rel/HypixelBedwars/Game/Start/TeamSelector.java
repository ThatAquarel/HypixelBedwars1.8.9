package me.Aqua_rel.HypixelBedwars.Game.Start;

import me.Aqua_rel.HypixelBedwars.Plugin;
import me.Aqua_rel.HypixelBedwars.Utilities.GetPlayerHead;
import me.Aqua_rel.HypixelBedwars.Utilities.SetItemQty;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class TeamSelector implements Listener {
    public final Inventory inv;
    private final Plugin plugin;
    private final Teams teams;

    @SuppressWarnings("deprecation")
    public TeamSelector(Plugin _plugin, Teams _teams) {
        this.inv = Bukkit.createInventory(null, 18, "Team Selector");
        this.teams = _teams;
        this.plugin = _plugin;

        for (TeamItems team : TeamItems.values()) {
            ItemStack itemStack = new ItemStack(Material.getMaterial(team.item()), 1,
                    team.datavalue().shortValue());
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(team.display());
            itemMeta.setLore(Collections.singletonList(team.lore()));
            itemStack.setItemMeta(itemMeta);

            this.inv.setItem(team.pos(), itemStack);

        }

        ItemStack spectator = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta spectatorMeta = (SkullMeta) spectator.getItemMeta();
        GetPlayerHead.mutateItemMeta(spectatorMeta, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVkODdhNGMzYmJjNDU1NjY1YTU1OTI5NzA4NGUwNTliMjk4NmU1YzIyNThiNDQ5ZWEwZjE3YTBiMTJhZGRhYyJ9fX0");
        spectatorMeta.setDisplayName(ChatColor.WHITE + "Spectator");
        spectatorMeta.setLore(Collections.singletonList(ChatColor.AQUA + "Click to select!"));
        spectator.setItemMeta(spectatorMeta);

        this.inv.setItem(13, spectator);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void selectTeam(InventoryClickEvent e) {
        if (e.getClick() != ClickType.UNKNOWN && e.getClick() != null && e.getClickedInventory() != null) {
            String title = e.getClickedInventory().getTitle();
            Player player = Bukkit.getPlayer(e.getWhoClicked().getUniqueId());

            if (title.equals("Team Selector")) {
                //Bukkit.getConsoleSender().sendMessage(String.valueOf(e.getSlot()));

                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);

                switch (e.getSlot()) {
                    case 1:
                        player.sendMessage(ChatColor.BOLD + "You are in " + ChatColor.RED + "RED" + ChatColor.RESET + ChatColor.BOLD + " Team!");
                        clearTeam(player);
                        this.teams.red.add(player);
                        break;
                    case 3:
                        player.sendMessage(ChatColor.BOLD + "You are in " + ChatColor.BLUE + "BLUE" + ChatColor.RESET + ChatColor.BOLD + " Team!");
                        clearTeam(player);
                        this.teams.blue.add(player);
                        break;
                    case 5:
                        player.sendMessage(ChatColor.BOLD + "You are in " + ChatColor.GREEN + "GREEN" + ChatColor.RESET + ChatColor.BOLD + " Team!");
                        clearTeam(player);
                        this.teams.green.add(player);
                        break;
                    case 7:
                        player.sendMessage(ChatColor.BOLD + "You are in " + ChatColor.YELLOW + "YELLOW" + ChatColor.RESET + ChatColor.BOLD + " Team!");
                        clearTeam(player);
                        this.teams.yellow.add(player);
                        break;
                    case 13:
                        player.sendMessage(ChatColor.BOLD + "You are a SPECTATOR!");
                        clearTeam(player);
                        this.teams.spec.add(player);
                        break;
                    default:
                        break;
                }

                ItemStack red = inv.getItem(TeamItems.RED.pos());
                SetItemQty.setItemQty(red, this.teams.red.size() + 1);
                inv.setItem(TeamItems.RED.pos(), red);

                ItemStack blue = inv.getItem(TeamItems.BLUE.pos());
                SetItemQty.setItemQty(blue, this.teams.blue.size() + 1);
                inv.setItem(TeamItems.BLUE.pos(), blue);

                ItemStack green = inv.getItem(TeamItems.GREEN.pos());
                SetItemQty.setItemQty(green, this.teams.green.size() + 1);
                inv.setItem(TeamItems.GREEN.pos(), green);

                ItemStack yellow = inv.getItem(TeamItems.YELLOW.pos());
                SetItemQty.setItemQty(yellow, this.teams.yellow.size() + 1);
                inv.setItem(TeamItems.YELLOW.pos(), yellow);

                ItemStack spec = inv.getItem(13);
                SetItemQty.setItemQty(spec, this.teams.spec.size() + 1);
                inv.setItem(13, spec);

                reload(inv);

                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void closeTeamSelector(InventoryCloseEvent e) {
        String title = e.getInventory().getTitle();
        Player player = (Player) e.getPlayer();

        if (title.equals("Team Selector")) {
            if (!this.teams.red.contains(player) && !this.teams.blue.contains(player) && !this.teams.green.contains(player) && !this.teams.yellow.contains(player) && !this.teams.spec.contains(player)) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> player.openInventory(this.inv), 1);
            }
        }
    }

    private void clearTeam(Player player) {
        this.teams.red.remove(player);
        this.teams.blue.remove(player);
        this.teams.green.remove(player);
        this.teams.yellow.remove(player);
        this.teams.spec.remove(player);
    }

    private void reload(Inventory inv) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.openInventory(inv);
        }
    }
}
