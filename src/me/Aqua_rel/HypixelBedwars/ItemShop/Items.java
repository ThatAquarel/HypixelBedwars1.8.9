package me.Aqua_rel.HypixelBedwars.ItemShop;

import net.md_5.bungee.api.ChatColor;

public enum Items {
    WOOL("Blocks", 19, 16, 35, 0, "Wool", "Great for bridging across\nislands. Turns into your team's\ncolor.\n\n", 4, 265),
    CLAY("Blocks", 20, 16, 172, 0, "Hardened Clay", "Basic block to denfend your bed.\n\n", 12, 265),
    GLASS("Blocks", 21, 4, 20, 0, "Blast-Proof Glass", "Immune to explosions.\n\n", 12, 265),
    ENDSTONE("Blocks", 22, 12, 121, 0, "End Stone", "Solid block to defend your bed.\n\n", 24, 265),
    LADDER("Blocks", 23, 16, 65, 0, "Ladder", "Useful to save cats stuck in\ntrees.\n\n", 4, 265),
    WOOD("Blocks", 24, 16, 5, 0, "Oak Wood Planks", "Good block to defend your bed.\nStrong against pickaxes.\n\n", 4, 266),
    OBSIDIAN("Blocks", 25, 4, 49, 0, "Obsidian", "Extreme protection for your bed.\n\n", 4, 388),

    ARROW("Ranged", 19, 8, 262, 0, "Arrow", "", 2, 266),
    BOW("Ranged", 20, 1, 261, 0, "Bow", "", 12, 266),
    BOWPOWER("Ranged", 21, 1, 261, 0, "Bow (Power I)", "", 24, 266),
    BOWPOWERPUNCH("Ranged", 22, 1, 261, 0, "Bow (Power I, Punch I)", "", 6, 388),

    SPEED("Potions", 19, 1, 373, 8195, "Speed II Potion (45 Seconds)", ChatColor.BLUE + "Speed II (0:45)\n\n", 1, 388),
    JUMP("Potions", 20, 1, 373, 8203, "Jump V Potion (45 Seconds)", ChatColor.BLUE + "Jump V (0:45)\n\n", 1, 388),
    INVISIBILITY("Potions", 21, 1, 373, 8206, "Invisibility Potion (30 Seconds)", ChatColor.BLUE + "Complete " + "Invisibility (0:30)\n\n", 2, 388),

    GOLDAPPLE("Utility", 19, 1, 322, 0, "Golden Apple", "Well-rounded healing.\n\n", 3, 266),
    BEDBUG("Utility", 20, 1, 332, 0, "Bedbug", "Spawns silverfish where the\nsnowball lands to distract your\nenemies" + ". Lasts 15 seconds.\n\n", 40, 265),
    DEFENDER("Utility", 21, 1, 383, 99, "Dream Defender", "Iron Golems to help defend your\nbase. Lasts 4 minutes" + ".\n\n", 120, 265),
    FIREBALL("Utility", 22, 1, 385, 0, "Fireball", "Right click to launch! Great to\nknock back enemies walking " + "on\nthin bridges.\n\n", 40, 265),
    TNT("Utility", 23, 1, 46, 0, "TNT", "Instantly ignites, appropriate\nto explode things!\n\n", 4, 266),
    ENDERPEARL("Utility", 24, 1, 368, 0, "Ender Pearl", "The quickest way to invade enemy\nbases.\n\n", 4, 388),
    WATER("Utility", 25, 1, 326, 0, "Water Bucket", "Great to slow down approaching\nenemies. Can also " + "protect\nagainst" + " TNT.\n\n", 3, 266),
    BRIDGEEGG("Utility", 28, 1, 344, 0, "Bridge Egg", "This egg creates a bridge in its\ntrail after being thrown.\n\n", 2, 388),
    MILK("Utility", 29, 1, 335, 0, "Magic Milk", "Avoid triggering traps for 30\nseconds after consuming.\n\n", 4, 266),
    SPONGE("Utility", 30, 4, 19, 0, "Sponge", "Great for soaking up water.\n\n", 3, 266),
    POPUPTOWER("Utility", 31, 1, 146, 0, "Compact Pop-up Tower", "Place a pop-up defence!\n\n", 24, 265);


    private final String Menu;
    private final Integer Position;
    private final Integer Quantity;

    private final Integer Item;
    private final Integer DataValue;
    private final String DisplayName;
    private final String DisplayLore;

    private final Integer Price;
    private final Integer Material;

    Items(String Menu, Integer Position, Integer Quantity, Integer Item, Integer DataValue, String DisplayName, String DisplayLore, Integer Price, Integer Material) {
        this.Menu = Menu;
        this.Position = Position;
        this.Quantity = Quantity;
        this.Item = Item;
        this.DataValue = DataValue;
        this.DisplayName = DisplayName;
        this.DisplayLore = DisplayLore;
        this.Price = Price;
        this.Material = Material;
    }

    public String menu() {
        return this.Menu;
    }

    public Integer pos() {
        return this.Position;
    }

    public Integer qty() {
        return this.Quantity;
    }

    public Integer item() {
        return this.Item;
    }

    public Integer datavalue() {
        return this.DataValue;
    }

    public String display() {
        return this.DisplayName;
    }

    public String lore() {
        return this.DisplayLore;
    }

    public Integer price() {
        return this.Price;
    }

    public Integer payment() {
        return this.Material;
    }
}
