package me.Aqua_rel.HypixelBedwars.Utilities;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class SetMenu {
    @SuppressWarnings("deprecation")
    public static void setMenu(Inventory inv) {
        Integer[] positions = {0, 1, 2, 3, 4, 5, 6, 7};
        Integer[] items = {399, 172, 283, 305, 274, 261, 379, 46};
        Short[] dataValues = {0, 0, 0, 0, 0, 0, 0, 0};
        Integer[] quantities = {1, 1, 1, 1, 1, 1, 1, 1};
        String[] itemNames = {ChatColor.GREEN + "Quick Buy", ChatColor.GREEN + "Blocks", ChatColor.GREEN + "Melee",
                ChatColor.GREEN + "Armor", ChatColor.GREEN + "Tools", ChatColor.GREEN + "Ranged", ChatColor.GREEN +
                "Potions", ChatColor.GREEN + "Utilities"};
        String[] itemLores = {ChatColor.YELLOW + "Click to view!", ChatColor.YELLOW + "Click to view!", ChatColor.YELLOW
                + "Click to view!", ChatColor.YELLOW + "Click to view!", ChatColor.YELLOW + "Click to view!",
                ChatColor.YELLOW + "Click to view!", ChatColor.YELLOW + "Click to view!", ChatColor.YELLOW + "Click to view!"};

        SetItems.setItems(inv, positions, items, dataValues, quantities, itemNames, itemLores);

        ItemStack separatorItem = new ItemStack(Material.getMaterial(160), 1, (short) 7);
        ItemMeta separatorItemMeta = separatorItem.getItemMeta();
        separatorItemMeta.setDisplayName(ChatColor.GRAY + "\u2191" + ChatColor.RESET + " Categories");
        separatorItemMeta.setLore(Collections.singletonList(ChatColor.GRAY + "\u2193" + ChatColor.RESET + " Items"));
        separatorItem.setItemMeta(separatorItemMeta);
        for (int i = 9; i < 18; i++) {
            inv.setItem(i, separatorItem);
        }
    }
}
