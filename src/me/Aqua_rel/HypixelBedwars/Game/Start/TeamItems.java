package me.Aqua_rel.HypixelBedwars.Game.Start;

import net.md_5.bungee.api.ChatColor;

public enum TeamItems {
    RED(1, 160, 14, ChatColor.RED + "Red Team", ChatColor.AQUA + "Click to select!"),
    BLUE(3, 160, 11, ChatColor.BLUE + "Blue Team", ChatColor.AQUA + "Click to select!"),
    GREEN(5, 160, 13, ChatColor.GREEN + "Green Team", ChatColor.AQUA + "Click to select!"),
    YELLOW(7, 160, 4, ChatColor.YELLOW + "Yellow Team", ChatColor.AQUA + "Click to select!");

    private final Integer Position;

    private final Integer Item;
    private final Integer DataValue;
    private final String DisplayName;
    private final String DisplayLore;

    TeamItems(Integer Position, Integer Item, Integer DataValue, String DisplayName,
              String DisplayLore) {
        this.Position = Position;
        this.Item = Item;
        this.DataValue = DataValue;
        this.DisplayName = DisplayName;
        this.DisplayLore = DisplayLore;
    }

    public Integer pos() {
        return this.Position;
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
}
