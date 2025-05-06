package me.daniel.marvelousmod.item.custom;

import me.daniel.marvelousmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = createChiselMap();

    private static Map<Block, Block> createChiselMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STONE, Blocks.STONE_BRICKS);
        map.put(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS);
        map.put(Blocks.CHISELED_STONE_BRICKS, Blocks.STONE);
        map.put(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        map.put(Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE);
        map.put(Blocks.CHISELED_DEEPSLATE, Blocks.DEEPSLATE);
        map.put(Blocks.SAND, Blocks.SANDSTONE);
        map.put(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE);
        map.put(Blocks.CHISELED_SANDSTONE, Blocks.GLASS);
        map.put(Blocks.GLASS, Blocks.SAND);
        map.put(Blocks.RED_SAND, Blocks.RED_SANDSTONE);
        map.put(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE);
        map.put(Blocks.CHISELED_RED_SANDSTONE, Blocks.RED_STAINED_GLASS);
        map.put(Blocks.RED_STAINED_GLASS, Blocks.RED_SAND);
        map.put(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        map.put(Blocks.TUFF, Blocks.TUFF_BRICKS);
        map.put(Blocks.TERRACOTTA, Blocks.BRICKS);
        map.put(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS);
        map.put(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK);
        map.put(Blocks.BOOKSHELF, Blocks.CHISELED_BOOKSHELF);
        map.put(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS);
        map.put(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS);
        map.put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG);
        map.put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG);
        map.put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG);
        map.put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG);
        map.put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG);
        map.put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG);
        map.put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG);
        map.put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM);
        map.put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM);
        map.put(Blocks.PALE_OAK_LOG, Blocks.PALE_OAK_LOG);
        map.put(Blocks.DIAMOND_ORE, ModBlocks.PINK_GARNET_ORE);
        map.put(Blocks.DEEPSLATE_DIAMOND_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        map.put(Blocks.DIAMOND_BLOCK, ModBlocks.PINK_GARNET_BLOCK);
        map.put(Blocks.DIRT, ModBlocks.CONDENSED_DIRT_BLOCK);
        return Collections.unmodifiableMap(map);
    }

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                ((ServerWorld) world).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, clickedBlock.getDefaultState()),
                        context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 1.0,
                        context.getBlockPos().getZ() + 0.5, 50, 0, 0, 0, 1);
            }
        }
        return ActionResult.SUCCESS;
    }
}
