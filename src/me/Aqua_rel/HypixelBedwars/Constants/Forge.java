package me.Aqua_rel.HypixelBedwars.Constants;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum Forge {
    RED(new Location(Bukkit.getWorld("world"), -52.5, 93, -52.5)),
    BLUE(new Location(Bukkit.getWorld("world"), 51.5, 93, -52.5)),
    GREEN(new Location(Bukkit.getWorld("world"), 51.5, 93, 51.5)),
    YELLOW(new Location(Bukkit.getWorld("world"), -52.5, 93, 51.5));

    private final Location location;

    Forge(Location location) {
        this.location = location;
    }

    public Location getType() {
        return this.location;
    }
}
