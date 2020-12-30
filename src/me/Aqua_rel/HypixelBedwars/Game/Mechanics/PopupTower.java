package me.Aqua_rel.HypixelBedwars.Game.Mechanics;

import me.Aqua_rel.HypixelBedwars.Commands.Start;
import me.Aqua_rel.HypixelBedwars.Plugin;
import me.Aqua_rel.HypixelBedwars.Utilities.GetRelativeBlockface;
import me.Aqua_rel.HypixelBedwars.Utilities.PlaySound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Chest;
import org.bukkit.material.Ladder;

public class PopupTower implements Listener {
    private final Plugin plugin;
    private final Start start;

    public PopupTower(Plugin _plugin, Start _start) {
        this.plugin = _plugin;
        this.start = _start;
    }

    @EventHandler(priority = EventPriority.HIGH)
    @SuppressWarnings("deprecation")
    public void placeTower(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.TRAPPED_CHEST)) {
            Chest chest = new Chest(0, e.getBlock().getData());

            createWideWall(e.getBlock(), chest.getFacing(), 1, e.getPlayer());
            createWideWall(e.getBlock(), GetRelativeBlockface.getOpposite(chest.getFacing()), 2, e.getPlayer());
            createThinWallRight(e.getBlock(), GetRelativeBlockface.getRight(chest.getFacing()));
            createThinWallLeft(e.getBlock(), GetRelativeBlockface.getLeft(chest.getFacing()));

            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> setLadders(e.getBlock(), chest.getFacing()), 2L);

            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> fillGaps(e.getBlock(), chest.getFacing()), 20L);

            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> setDoor(e.getBlock(), chest.getFacing()), 5L);

            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                create3Spikes(e.getBlock(), chest.getFacing(), 2, e.getPlayer());
                create3Spikes(e.getBlock(), GetRelativeBlockface.getOpposite(chest.getFacing()), 3, e.getPlayer());

                create2SpikesRight(e.getBlock(), GetRelativeBlockface.getRight(chest.getFacing()));
                create2SpikesLeft(e.getBlock(), GetRelativeBlockface.getLeft(chest.getFacing()));

                createPlatform(e.getBlock(), chest.getFacing());

                //fillGaps(e.getBlock(), chest.getFacing());
                fillBigGaps(e.getBlock(), chest.getFacing());
                fillSmallGaps(e.getBlock(), chest.getFacing());
            }, 10L);

            e.setCancelled(true);

            ItemStack handItem = e.getPlayer().getItemInHand();
            if (handItem.getAmount() > 1) {
                handItem.setAmount(handItem.getAmount() - 1);
                e.getPlayer().setItemInHand(handItem);
            } else if (handItem.getAmount() == 1) {
                e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
            }
        }
    }

    private void createWideWall(Block block, BlockFace blockFace, int offset, Player player) {
        final Block baseBlock = block.getRelative(blockFace, offset);
        final Block leftBlock = baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace));
        final Block rightBlock = baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace));

        setBlock(baseBlock, Material.WOOL);

        setBlock(leftBlock, Material.WOOL);

        setBlock(rightBlock, Material.WOOL);

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block baseBlockY = Bukkit.getWorld("world").getBlockAt(baseBlock.getX(), baseBlock.getY() + finalI,
                        baseBlock.getZ());
                setBlock(baseBlockY, Material.WOOL);

                Block leftBlockY = Bukkit.getWorld("world").getBlockAt(leftBlock.getX(), leftBlock.getY() + finalI,
                        leftBlock.getZ());
                setBlock(leftBlockY, Material.WOOL);

                Block rightBlockY = Bukkit.getWorld("world").getBlockAt(rightBlock.getX(), rightBlock.getY() + finalI,
                        rightBlock.getZ());
                setBlock(rightBlockY, Material.WOOL);

                PlaySound.eggPlop(player);
            }, i * 2);
        }
    }

    private void createThinWallRight(Block block, BlockFace blockFace) {
        final Block baseBlock = block.getRelative(blockFace, 2);
        final Block leftBlock = baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace));

        setBlock(baseBlock, Material.WOOL);

        setBlock(leftBlock, Material.WOOL);

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block baseBlockY = Bukkit.getWorld("world").getBlockAt(baseBlock.getX(), baseBlock.getY() + finalI,
                        baseBlock.getZ());
                setBlock(baseBlockY, Material.WOOL);

                Block leftBlockY = Bukkit.getWorld("world").getBlockAt(leftBlock.getX(), leftBlock.getY() + finalI,
                        leftBlock.getZ());
                setBlock(leftBlockY, Material.WOOL);

            }, i * 2);
        }
    }

    private void createThinWallLeft(Block block, BlockFace blockFace) {
        final Block baseBlock = block.getRelative(blockFace, 2);
        final Block rightBlock = baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace));

        setBlock(baseBlock, Material.WOOL);

        setBlock(rightBlock, Material.WOOL);

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block baseBlockY = Bukkit.getWorld("world").getBlockAt(baseBlock.getX(), baseBlock.getY() + finalI,
                        baseBlock.getZ());
                setBlock(baseBlockY, Material.WOOL);

                Block rightBlockY = Bukkit.getWorld("world").getBlockAt(rightBlock.getX(), rightBlock.getY() + finalI,
                        rightBlock.getZ());
                setBlock(rightBlockY, Material.WOOL);

            }, i * 2);
        }
    }

    private void create3Spikes(Block block, BlockFace blockFace, int offset, Player player) {
        Block _baseBlock = block.getRelative(blockFace, offset);
        Block baseBlock = _baseBlock.getRelative(BlockFace.UP, 5);
        Block leftBlock = baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace), 2);
        Block rightBlock = baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace), 2);

        setBlock(baseBlock, Material.WOOL);

        setBlock(leftBlock, Material.WOOL);

        setBlock(rightBlock, Material.WOOL);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block baseBlockY = Bukkit.getWorld("world").getBlockAt(baseBlock.getX(), baseBlock.getY() + finalI,
                        baseBlock.getZ());
                setBlock(baseBlockY, Material.WOOL);

                Block leftBlockY = Bukkit.getWorld("world").getBlockAt(leftBlock.getX(), leftBlock.getY() + finalI,
                        leftBlock.getZ());
                setBlock(leftBlockY, Material.WOOL);

                Block rightBlockY = Bukkit.getWorld("world").getBlockAt(rightBlock.getX(), rightBlock.getY() + finalI,
                        rightBlock.getZ());
                setBlock(rightBlockY, Material.WOOL);

                PlaySound.eggPlop(player);
            }, i * 2L);
        }
    }

    private void create2SpikesRight(Block block, BlockFace blockFace) {
        Block __baseBlock = block.getRelative(blockFace, 3);
        Block _baseBlock = __baseBlock.getRelative(BlockFace.UP, 5);
        Block leftBlock = _baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace), 1);
        Block rightBlock = _baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace), 2);

        setBlock(leftBlock, Material.WOOL);

        setBlock(rightBlock, Material.WOOL);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block leftBlockY = Bukkit.getWorld("world").getBlockAt(leftBlock.getX(), leftBlock.getY() + finalI,
                        leftBlock.getZ());
                setBlock(leftBlockY, Material.WOOL);

                Block rightBlockY = Bukkit.getWorld("world").getBlockAt(rightBlock.getX(), rightBlock.getY() + finalI,
                        rightBlock.getZ());
                setBlock(rightBlockY, Material.WOOL);

            }, i * 2L);
        }
    }

    private void create2SpikesLeft(Block block, BlockFace blockFace) {
        Block __baseBlock = block.getRelative(blockFace, 3);
        Block _baseBlock = __baseBlock.getRelative(BlockFace.UP, 5);
        Block leftBlock = _baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace), 2);
        Block rightBlock = _baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace), 1);

        setBlock(leftBlock, Material.WOOL);

        setBlock(rightBlock, Material.WOOL);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block leftBlockY = Bukkit.getWorld("world").getBlockAt(leftBlock.getX(), leftBlock.getY() + finalI,
                        leftBlock.getZ());
                setBlock(leftBlockY, Material.WOOL);

                Block rightBlockY = Bukkit.getWorld("world").getBlockAt(rightBlock.getX(), rightBlock.getY() + finalI,
                        rightBlock.getZ());
                setBlock(rightBlockY, Material.WOOL);

            }, i * 2L);
        }
    }

    private void createPlatform(Block block, BlockFace blockFace) {
        Block baseBlock = block.getRelative(BlockFace.UP, 5);
        Block leftBlock = baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace));
        Block rightBlock = baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace));
        Block _leftBlock = leftBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace));
        Block _rightBlock = rightBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace));

        setBlock(_leftBlock, Material.WOOL);
        setBlock(_rightBlock, Material.WOOL);
        setBlock(baseBlock, Material.WOOL);
        setBlock(leftBlock, Material.WOOL);
        setBlock(rightBlock, Material.WOOL);
    }

    private void fillBigGaps(Block block, BlockFace blockFace) {
        Block baseBlock = block.getRelative(BlockFace.UP, 6);
        Block leftBlock = baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace));
        Block rightBlock = baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace));
        Block _leftBlock = leftBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace), 3);
        Block _rightBlock = rightBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace), 3);
        Block __leftBlock = leftBlock.getRelative(blockFace, 2);
        Block __rightBlock = rightBlock.getRelative(blockFace, 2);

        setBlock(_leftBlock, Material.WOOL);
        setBlock(_rightBlock, Material.WOOL);
        setBlock(__leftBlock, Material.WOOL);
        setBlock(__rightBlock, Material.WOOL);
    }

    private void fillSmallGaps(Block block, BlockFace blockFace) {
        Block baseBlock = block.getRelative(BlockFace.UP, 6);
        Block leftBlock = baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace), 3);
        Block rightBlock = baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace), 3);
        Block _leftBlock = leftBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace));
        Block _rightBlock = rightBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace));

        setBlock(leftBlock, Material.WOOL);

        setBlock(rightBlock, Material.WOOL);

        setBlock(_leftBlock, Material.WOOL);

        setBlock(_rightBlock, Material.WOOL);
    }

    @SuppressWarnings("deprecation")
    private void setLadders(Block block, BlockFace blockFace) {
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                Block baseBlock = block.getRelative(GetRelativeBlockface.getOpposite(blockFace), 1).getRelative(BlockFace.UP, finalI);

                if (setBlock(baseBlock, Material.LADDER)) {
                    Ladder ladder = new Ladder(0, baseBlock.getData());
                    ladder.setFacingDirection(GetRelativeBlockface.getOpposite(blockFace));
                    baseBlock.setData(ladder.getData());
                }
            }, i * 2);
        }
    }

    private void setDoor(Block block, BlockFace blockFace) {
        Block baseBlock = block.getRelative(blockFace, 1);
        Block upBlock = baseBlock.getRelative(BlockFace.UP, 1);
        Block _upBlock = upBlock.getRelative(BlockFace.UP, 1);

        setAir(baseBlock);

        setAir(upBlock);

        setAir(_upBlock);
    }

    private void fillGaps(Block block, BlockFace blockFace) {
        Block baseBlock = block.getRelative(blockFace, 1);
        Block _baseBlock = baseBlock.getRelative(BlockFace.UP, 5);
        Block rightBlock = _baseBlock.getRelative(GetRelativeBlockface.getRight(blockFace), 2);
        Block leftBlock = _baseBlock.getRelative(GetRelativeBlockface.getLeft(blockFace), 2);
        Block _rightBlock = rightBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace), 3);
        Block _leftBlock = leftBlock.getRelative(GetRelativeBlockface.getOpposite(blockFace), 3);

        setBlock(rightBlock, Material.WOOL);

        setBlock(leftBlock, Material.WOOL);

        setBlock(_rightBlock, Material.WOOL);

        setBlock(_leftBlock, Material.WOOL);
    }

    private void setAir(Block block) {
        if (!block.getType().equals(Material.AIR)) {
            if (start.blockEvents.getPlacedBlocks().contains(block)) {
                block.setType(Material.AIR);
                start.blockEvents.removeBlock(block);
            }
        }
    }

    @SuppressWarnings("SameParameterValue")
    private boolean setBlock(Block block, Material material) {
        if (block.getType().equals(Material.AIR)) {
            block.setType(material);
            start.blockEvents.addBlock(block);
            return true;
        } else {
            return false;
        }
    }
}

