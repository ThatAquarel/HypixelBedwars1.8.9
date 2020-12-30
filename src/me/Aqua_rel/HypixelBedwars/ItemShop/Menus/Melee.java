package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Melee {
public void meleeInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "Melee");

		SetMenu.setMenu(inv);
		SetCategory.setCategory(inv,11);

		player.openInventory(inv);
	}
}
