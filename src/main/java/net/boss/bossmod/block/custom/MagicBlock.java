package net.boss.bossmod.block.custom;

import net.boss.bossmod.block.ModBlocks;
import net.boss.bossmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class MagicBlock extends Block {

    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.RABBIT_FOOT) {
                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.DIAMOND_BLOCK) {
                itemEntity.setItem(new ItemStack(Items.NETHERITE_INGOT, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.STONE) {
                itemEntity.setItem(new ItemStack(Items.STONE_BRICKS, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.END_STONE) {
                itemEntity.setItem(new ItemStack(Items.END_STONE_BRICKS, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.DEEPSLATE) {
                itemEntity.setItem(new ItemStack(Items.DEEPSLATE_BRICKS, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.DIRT) {
                itemEntity.setItem(new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get(), itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.bossmod.magic_block.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
