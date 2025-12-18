package net.boss.bossmod.datagen;

import net.boss.bossmod.item.ModItems;
import net.boss.bossmod.BossMod;
import net.boss.bossmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, BossMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(ItemTags.SWORDS).add(ModItems.ALEXANDRITE_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.ALEXANDRITE_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.ALEXANDRITE_SHOVEL.get());
        tag(ItemTags.AXES).add(ModItems.ALEXANDRITE_AXE.get());
        tag(ItemTags.HOES).add(ModItems.ALEXANDRITE_HOE.get());
        tag(ItemTags.BOW_ENCHANTABLE).add(ModItems.KAUPEN_BOW.get());
        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get());

        tag(ModTags.Items.HAMMER_PICKAXE)
                .add(ModItems.ALEXANDRITE_HAMMER.get());
//        tag(ModTags.Items.HAMMER_EXCLUSIVE)
//                .add(ModItems.ALEXANDRITE_HAMMER.get());

        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ALEXANDRITE.get())
                .add(ModItems.RAW_ALEXANDRITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ALEXANDRITE.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KAUPEN_SMITHING_TEMPLATE.get());
    }
}