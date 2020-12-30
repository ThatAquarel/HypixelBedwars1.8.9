package me.Aqua_rel.HypixelBedwars.Utilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SubtractItem{
    @SuppressWarnings("deprecation")
    public static void buyItem(Player player, Integer material, Integer price){
        int difference = GetPlayerItem.countItem(player, material) - price;
        player.getInventory().remove(material);
        if(difference > 0){
            player.getInventory().addItem(new ItemStack(Material.getMaterial(material), difference));
        }
    }
}