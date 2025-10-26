package net.boss.bossmod.datagen;

import net.boss.bossmod.BossMod;
import net.boss.bossmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper helper) {
        super(output, registries, helper, List.of(new AlexandriteTest()));
    }

    public static class AlexandriteTest implements AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
            Advancement.Builder.advancement()
                    .display(ModItems.RAW_ALEXANDRITE.get(), Component.translatable("advancements.alexandrite.root.title"),
                            Component.translatable("advancements.alexandrite.root.description"),
                            ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID ,"textures/block/alexandrite_block.png"),
                            AdvancementType.TASK, true, true, true)
                    .addCriterion("AlexandriteStart", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_ALEXANDRITE.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/root"));
        }
    }
}
