package me.Aqua_rel.HypixelBedwars.ItemShop.EventHandlers;

import me.Aqua_rel.HypixelBedwars.ItemShop.Menus.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuNavigate implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void navigateShop(InventoryClickEvent e) {
        if (e.getClick() != ClickType.UNKNOWN && e.getClick() != null && e.getClickedInventory() != null) {
            String title = e.getClickedInventory().getTitle();
            if (!title.equals("container.chest") && !title.equals("container.enderchest") && !title.equals("container" +
                    ".inventory") && !title.equals("container.crafting") && !title.equals("Team Selector")) {
                //Bukkit.getServer().getConsoleSender().sendMessage("menu clicked");
                //Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(e.getSlot()));

                Player p = Bukkit.getPlayer(e.getWhoClicked().getUniqueId());

                switch (e.getSlot()) {
                    case 0:
                        QuickBuy quickBuy = new QuickBuy();
                        quickBuy.quickbuyInv(p);
                        break;
                    case 1:
                        Blocks blocks = new Blocks();
                        blocks.blocksInv(p);
                        break;
                    case 2:
                        Melee melee = new Melee();
                        melee.meleeInv(p);
                        break;
                    case 3:
                        Armor armor = new Armor();
                        armor.armorInv(p);
                        break;
                    case 4:
                        Tools tools = new Tools();
                        tools.toolsInv(p);
                        break;
                    case 5:
                        Bows bows = new Bows();
                        bows.bowsInv(p);
                        break;
                    case 6:
                        Potions potions = new Potions();
                        potions.potionsInv(p);
                        break;
                    case 7:
                        Utilities utilities = new Utilities();
                        utilities.utilitiesInv(p);
                        break;
                    default:
                        break;
                }

                p.setItemOnCursor(new ItemStack(Material.AIR));

                e.setCancelled(true);
            }
        }
    }
}
