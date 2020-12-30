package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Armor {
public void armorInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "Armor");

		SetMenu.setMenu(inv);
		SetCategory.setCategory(inv,12);

		player.openInventory(inv);
	}
}
