package me.Aqua_rel.HypixelBedwars.Utilities;

import org.bukkit.inventory.ItemStack;

public class SetItemQty {
    public static ItemStack setItemQty(ItemStack itemStack, int qty) {
        itemStack.setAmount(qty);
        return itemStack;
    }
}
