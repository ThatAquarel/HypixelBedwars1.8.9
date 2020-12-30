package me.Aqua_rel.HypixelBedwars;

import org.bukkit.entity.Player;

import java.util.Map;

public class Maps {
    public static Map<Player, String> players;

    public static Map<String, Integer> sharpness; //0(no sharp), 1(sharp I)
    public static Map<String, Integer> protection; //0(no prot), 1(prot I), 2(prot II), 3(prot III), 4(prot IV)
    public static Map<String, Integer> haste; //0(no haste), 1(haste I), 2(haste II)
    public static Map<String, Integer> forge; //0(no forge), 1(forge I), 2(forge II), 3(forge III), 4(forge IV)
    public static Map<String, Integer> dragon; //0(no dragon), 1(dragon)
    public static Map<String, Integer> trap; //0(no trap), 1(its a trap), 2(counter offensive), 3(alarm trap), 4(miner)

    public static Map<Player, Integer> armor; //0(invisibility, none), 1(leather), 2(iron), 3(diamond)
    public static Map<Player, Integer> pick; //0(none), 1(wood), 2(iron), 3(gold), 4(diamond)
    public static Map<Player, Integer> axe; //0(none), 1(wood), 2(stone), 3(iron), 4(diamond)
    public static Map<Player, Integer> shears; //0(none), 1(shears)
}
