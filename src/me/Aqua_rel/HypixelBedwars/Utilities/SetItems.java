package me.Aqua_rel.HypixelBedwars.Utilities;

import me.Aqua_rel.HypixelBedwars.ItemShop.Items;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class SetItems {
    @SuppressWarnings("deprecation")
    public static void setItems(Inventory inv, Integer[] positions, Integer[] items, Short[] dataValues, Integer[] quantities, String[] itemNames, String[] itemLores) {
        for (int i = 0; i < positions.length; i++) {
            ItemStack itemStack = new ItemStack(Material.getMaterial(items[i]), 1, dataValues[i]);
            itemStack.setAmount(quantities[i]);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(itemNames[i]);
            itemMeta.setLore(Collections.singletonList(itemLores[i]));
            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            itemStack.setItemMeta(itemMeta);
            inv.setItem(positions[i], itemStack);
        }
    }

    @SuppressWarnings("deprecation")
    public static void setItemsFromEnum(Inventory inv, Player player, String menu) {
        for (Items item : Items.values()) {
            if (item.menu().equals(menu)) {
                ItemStack itemStack = new ItemStack(Material.getMaterial(item.item()), item.qty(),
                        item.datavalue().shortValue());
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(GetItem.itemName(item.display(), item.price(), GetPlayerItem.countItem(player
                        , item.payment())));

                String material = "";
                switch (item.payment()) {
                    case 265:
                        material = "Iron";
                        break;
                    case 266:
                        material = "Gold";
                        break;
                    case 388:
                        material = "Emerald";
                        break;
                }

                String[] lines = GetItem.itemLore(material, item.lore(), item.price(), GetPlayerItem.countItem(player
                        , item.payment())).split("\\r?\\n");
                for (int j = 0; j < lines.length; j++) {
                    lines[j] = ChatColor.GRAY + lines[j];
                }
                itemMeta.setLore(Arrays.asList(lines));

                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                itemStack.setItemMeta(itemMeta);

                inv.setItem(item.pos(), itemStack);
            }
        }
    }
}
