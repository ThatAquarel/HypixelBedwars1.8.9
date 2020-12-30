package me.Aqua_rel.HypixelBedwars.Utilities;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class SetCategory {
    public static void setCategory(Inventory inv, Integer category){
        ItemStack selectionItem = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
		ItemMeta selectionItemMeta = selectionItem.getItemMeta();
		selectionItemMeta.setDisplayName(ChatColor.GRAY + "\u2191" + ChatColor.RESET + " Categories");
		selectionItemMeta.setLore(Collections.singletonList(ChatColor.GRAY + "\u2193" + ChatColor.RESET + " Items"));
		selectionItem.setItemMeta(selectionItemMeta);
		inv.setItem(category, selectionItem);
    }
}
