package me.Aqua_rel.HypixelBedwars.ItemShop.Menus;

import me.Aqua_rel.HypixelBedwars.Utilities.SetCategory;
import me.Aqua_rel.HypixelBedwars.Utilities.SetMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class QuickBuy {
	public void quickbuyInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "Quick Buy");

		SetMenu.setMenu(inv);
		SetCategory.setCategory(inv,9);

		player.openInventory(inv);
	}
}
