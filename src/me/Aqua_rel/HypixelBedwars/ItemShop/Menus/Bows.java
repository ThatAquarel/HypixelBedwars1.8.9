package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetItems;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Bows {
    public void bowsInv(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Ranged");

        SetMenu.setMenu(inv);
        SetCategory.setCategory(inv, 14);
        SetItems.setItemsFromEnum(inv, player, "Ranged");

        player.openInventory(inv);
    }
}
