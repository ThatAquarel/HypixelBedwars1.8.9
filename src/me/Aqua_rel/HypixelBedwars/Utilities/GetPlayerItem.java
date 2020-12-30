package me.Aqua_rel.HypixelBedwars.Utilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetPlayerItem {
    @SuppressWarnings("deprecation")
    public static int countItem(Player p, Integer material) {
        int count = 0;
        ItemStack[] contents = p.getInventory().getContents();

        for (ItemStack content : contents) {
            if (content != null && content.getType() == Material.getMaterial(material)) {
                count += content.getAmount();
            }
        }

        return count;
    }
}
