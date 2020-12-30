package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Tools {
public void toolsInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "Tools");

		SetMenu.setMenu(inv);
		SetCategory.setCategory(inv,13);

		player.openInventory(inv);
	}
}
