package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetItems;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Utilities {
    public void utilitiesInv(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Utility");

        SetMenu.setMenu(inv);
        SetCategory.setCategory(inv, 16);
        SetItems.setItemsFromEnum(inv, player, "Utility");

        player.openInventory(inv);
    }
}
