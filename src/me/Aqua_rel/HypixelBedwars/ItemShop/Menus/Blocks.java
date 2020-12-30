package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetItems;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Blocks {
    public void blocksInv(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Blocks");

        SetMenu.setMenu(inv);
        SetCategory.setCategory(inv, 10);
        SetItems.setItemsFromEnum(inv, player, "Blocks");

        player.openInventory(inv);
    }
}
