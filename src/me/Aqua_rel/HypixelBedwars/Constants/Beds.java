package me.Aqua_rel.HypixelBedwars.Constants;

import org.bukkit.block.BlockFace;

public enum Beds {
    RED(-41, 94, -41, -42, 94, -41, BlockFace.WEST),
    BLUE(39, 94, -41, 39, 94, -42, BlockFace.NORTH),
    GREEN(39, 94, 39, 40, 94, 39, BlockFace.EAST),
    YELLOW(-41, 94, 39, -41, 94, 40, BlockFace.SOUTH);

    private final Integer Xfoot;
    private final Integer Yfoot;
    private final Integer Zfoot;

    private final Integer Xhead;
    private final Integer Yhead;
    private final Integer Zhead;

    private final BlockFace blockFace;

    Beds(Integer Xfoot, Integer Yfoot, Integer Zfoot, Integer Xhead, Integer Yhead, Integer Zhead, BlockFace blockFace) {
        this.Xfoot = Xfoot;
        this.Yfoot = Yfoot;
        this.Zfoot = Zfoot;

        this.Xhead = Xhead;
        this.Yhead = Yhead;
        this.Zhead = Zhead;

        this.blockFace = blockFace;
    }

    public Integer getYfoot() {
        return Yfoot;
    }

    public Integer getXfoot() {
        return Xfoot;
    }

    public Integer getZfoot() {
        return Zfoot;
    }

    public Integer getXhead() {
        return Xhead;
    }

    public Integer getYhead() {
        return Yhead;
    }

    public Integer getZhead() {
        return Zhead;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }
}
