package me.Aqua_rel.HypixelBedwars.Game.End;

import me.Aqua_rel.HypixelBedwars.Constants.Beds;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.Bed;

public class ReplaceBeds {
    @SuppressWarnings("deprecation")
    public static void replaceBeds() {
        for (Beds bed : Beds.values()) {
            Block blockHead = Bukkit.getWorld("world").getBlockAt(bed.getXhead(), bed.getYhead(), bed.getZhead());
            Block blockFoot = Bukkit.getWorld("world").getBlockAt(bed.getXfoot(), bed.getYfoot(), bed.getZfoot());
            BlockState headState = blockHead.getState();
            BlockState footState = blockFoot.getState();

            headState.setType(Material.BED_BLOCK);
            footState.setType(Material.BED_BLOCK);
            headState.setRawData((byte) 0x0);
            footState.setRawData((byte) 0x8);
            footState.update(true, false);
            headState.update(true, false);

            Bed bedHead = (Bed) headState.getData();
            bedHead.setHeadOfBed(true);
            bedHead.setFacingDirection(bed.getBlockFace());

            Bed bedFoot = (Bed) footState.getData();
            bedFoot.setHeadOfBed(false);
            bedFoot.setFacingDirection(bed.getBlockFace());

            footState.update(true, false);
            headState.update(true, true);
        }
    }
}
