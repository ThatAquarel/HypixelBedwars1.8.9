package me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers;

import me.Aqua_rel.HypixelBedwars.ItemShop.Items;
import me.Aqua_rel.HypixelBedwars.Utilities.GetPlayerItem;
import me.Aqua_rel.HypixelBedwars.Utilities.SubtractItem;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuyItem implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.HIGH)
    public void navigateShop(InventoryClickEvent e) {
        if (e.getClick() != ClickType.UNKNOWN && e.getClick() != null && e.getClickedInventory() != null) {
            String title = e.getClickedInventory().getTitle();
            Player player = Bukkit.getPlayer(e.getWhoClicked().getUniqueId());

            if (!title.equals("container.chest") && !title.equals("container.enderchest") && !title.equals("container" +
                    ".inventory") && !title.equals("container.crafting")) {
                for (Items item : Items.values()) {
                    if (item.menu().equals(title) && item.pos() == e.getSlot()) {
                        if (GetPlayerItem.countItem(player, item.payment()) >= item.price()) {
                            SubtractItem.buyItem(player, item.payment(), item.price());

                            ItemStack itemStack = new ItemStack(Material.getMaterial(item.item()), item.qty(),
                                    item.datavalue().shortValue());
                            ItemMeta itemMeta = itemStack.getItemMeta();
                            itemMeta.setDisplayName(ChatColor.RESET + item.display());
                            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                            itemStack.setItemMeta(itemMeta);

                            player.getInventory().addItem(itemStack);

                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                        } else {
                            String payment = "";
                            switch (item.payment()) {
                                case 265:
                                    payment = "Iron";
                                    break;
                                case 266:
                                    payment = "Gold";
                                    break;
                                case 388:
                                    payment = "Emerald";
                                    break;
                            }

                            player.sendMessage(ChatColor.RED + "You don't have enough " + payment + "! Need " + (item.price() - GetPlayerItem.countItem(player, item.payment())) + " more!");

                            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
                        }
                    }
                }
            }
        }
    }
}
