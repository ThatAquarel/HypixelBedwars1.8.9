package me.Aqua_rel.HypixelBedwars.Utilities;

import net.md_5.bungee.api.ChatColor;

public class GetItem {
    public static String itemName(String name, Integer price, Integer available){
        if (available >= price) {
            name = ChatColor.GREEN + name;
        } else {
            name = ChatColor.RED + name;
        }

        return name;
    }

    public static String itemLore(String material, String usage, Integer price, Integer available) {
        String lore = "";

        String materialColor = "";
        if (material.equals("Iron")) {
            materialColor = " " + ChatColor.WHITE;
        } else if (material.equals("Gold")) {
            materialColor = " " + ChatColor.GOLD;
        } else if (material.equals("Emerald")) {
            materialColor = " " + ChatColor.GREEN;
        }

        lore += ChatColor.GRAY + "Cost:" + materialColor + String.valueOf(price) + " " + material + "\n\n";
        lore += usage;

        if (available >= price) {
            lore += ChatColor.YELLOW + "Click to purchase!";
        } else {
            lore += ChatColor.RED + "You don't have enough " + material + "!";
        }

        return lore;
    }
}
