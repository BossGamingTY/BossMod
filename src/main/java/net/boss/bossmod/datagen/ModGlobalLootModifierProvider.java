package net.boss.bossmod.datagen;

import net.boss.bossmod.BossMod;
import net.boss.bossmod.enchantment.ModEnchantmentEffects;
import net.boss.bossmod.enchantment.ModEnchantments;
import net.boss.bossmod.item.ModItems;
import net.boss.bossmod.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, BossMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.@NotNull Provider registries) {
        this.add("kohlrabi_seeds_from_short_grass",
                new AddItemModifier(new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.KOHLRABI_SEEDS.get()));
        this.add("kohlrabi_seeds_to_tall_grass",
                new AddItemModifier(new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.KOHLRABI_SEEDS.get()));

        this.add("alexandrite_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ModItems.ALEXANDRITE.get()));
//        this.add("lighting_striker_from_ancient_city",
//                new AddItemModifier(new LootItemCondition[] {
//                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build()
//                }, EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchantments.LIGHTNING_STRIKER.get(), 1))));

        add("kohlrabi_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper"))
                        .and(LootItemRandomChanceCondition.randomChance(0.5f)).build() }, // modified by the creeper's own loot table
                ModItems.KOHLRABI.get()));
        add("bar_brawl_music_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper"))
                        .and(LootItemRandomChanceCondition.randomChance(0.005f)).build() },
                ModItems.BAR_BRAWL_MUSIC_DISC.get()));
    }
}