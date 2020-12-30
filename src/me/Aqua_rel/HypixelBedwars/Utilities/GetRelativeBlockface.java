package me.Aqua_rel.HypixelBedwars.Utilities;

import org.bukkit.block.BlockFace;

public class GetRelativeBlockface {
    public static BlockFace getOpposite(BlockFace blockFace) {
        BlockFace returnBlockFace = BlockFace.SELF;
        switch (blockFace) {
            case NORTH:
                returnBlockFace = BlockFace.SOUTH;
                break;
            case EAST:
                returnBlockFace = BlockFace.WEST;
                break;
            case SOUTH:
                returnBlockFace = BlockFace.NORTH;
                break;
            case WEST:
                returnBlockFace = BlockFace.EAST;
                break;
            default:
        }
        return returnBlockFace;
    }

    public static BlockFace getLeft(BlockFace blockFace) {
        BlockFace returnBlockFace = BlockFace.SELF;
        switch (blockFace) {
            case NORTH:
                returnBlockFace = BlockFace.WEST;
                break;
            case EAST:
                returnBlockFace = BlockFace.NORTH;
                break;
            case SOUTH:
                returnBlockFace = BlockFace.EAST;
                break;
            case WEST:
                returnBlockFace = BlockFace.SOUTH;
                break;
            default:
        }
        return returnBlockFace;
    }

    public static BlockFace getRight(BlockFace blockFace) {
        BlockFace returnBlockFace = BlockFace.SELF;
        switch (blockFace) {
            case NORTH:
                returnBlockFace = BlockFace.EAST;
                break;
            case EAST:
                returnBlockFace = BlockFace.SOUTH;
                break;
            case SOUTH:
                returnBlockFace = BlockFace.WEST;
                break;
            case WEST:
                returnBlockFace = BlockFace.NORTH;
                break;
            default:
        }
        return returnBlockFace;
    }
}
