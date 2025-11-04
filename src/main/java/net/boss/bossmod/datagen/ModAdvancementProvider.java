package net.boss.bossmod.datagen;

import net.boss.bossmod.BossMod;
import net.boss.bossmod.block.ModBlocks;
import net.boss.bossmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
            AdvancementHolder alexandriteStart = Advancement.Builder.advancement()
                    .display(ModItems.RAW_ALEXANDRITE.get(),
                            Component.translatable("advancements.alexandrite.root.title"),
                            Component.translatable("advancements.alexandrite.root.description"),
                            ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID ,"textures/block/alexandrite_block.png"),
                            AdvancementType.GOAL, true, true, true)
                    .addCriterion("AlexandriteStart", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_ALEXANDRITE.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/root"));

            AdvancementHolder alexandrite2 = Advancement.Builder.advancement()
                    .parent(alexandriteStart)
                    .display(ModItems.ALEXANDRITE.get(),
                            Component.translatable("advancements.alexandrite.smeltalexandrite.title"),
                            Component.translatable("advancements.alexandrite.smeltalexandrite.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("Alexandrite2", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite2"));

            AdvancementHolder chisel = Advancement.Builder.advancement()
                    .parent(alexandrite2)
                    .display(ModItems.CHISEL.get(),
                            Component.translatable("advancements.alexandrite.chisel.title"),
                            Component.translatable("advancements.alexandrite.chisel.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("Chisel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHISEL.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/chisel"));

            AdvancementHolder magic_block = Advancement.Builder.advancement()
                    .parent(chisel)
                    .display(ModBlocks.MAGIC_BLOCK.get(),
                            Component.translatable("advancements.alexandrite.magic_block.title"),
                            Component.translatable("advancements.alexandrite.magic_block.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("MagicBlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.MAGIC_BLOCK.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/magic_block"));

            AdvancementHolder radiation_orb = Advancement.Builder.advancement()
                    .parent(magic_block)
                    .display(ModItems.RADIATION_ORB.get(),
                            Component.translatable("advancements.alexandrite.radiation_orb.title"),
                            Component.translatable("advancements.alexandrite.radiation_orb.description"),
                            null,
                            AdvancementType.TASK, true, true, true)
                    .addCriterion("radiation_orb", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RADIATION_ORB.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/radiation_orb"));

            AdvancementHolder radiation_staff = Advancement.Builder.advancement()
                    .parent(radiation_orb)
                    .display(ModItems.RADIATION_STAFF.get(),
                            Component.translatable("advancements.alexandrite.radiation_staff.title"),
                            Component.translatable("advancements.alexandrite.radiation_staff.description"),
                            null,
                            AdvancementType.TASK, true, true, true)
                    .addCriterion("Radiation_staff", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RADIATION_STAFF.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/radiation_staff"));

            AdvancementHolder alexandrite_boots = Advancement.Builder.advancement()
                    .parent(alexandrite2)
                    .display(ModItems.ALEXANDRITE_BOOTS.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_boots.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_boots.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("Alexandrite_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_BOOTS.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_boots"));

            AdvancementHolder alexandrite_leggings = Advancement.Builder.advancement()
                    .parent(alexandrite_boots)
                    .display(ModItems.ALEXANDRITE_LEGGINGS.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_leggings.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_leggings.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("Alexandrite_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_LEGGINGS.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_leggings"));

            AdvancementHolder alexandrite_chestplate = Advancement.Builder.advancement()
                    .parent(alexandrite_leggings)
                    .display(ModItems.ALEXANDRITE_CHESTPLATE.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_chestplate.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_chestplate.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("Alexandrite_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_CHESTPLATE.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_chestplate"));

            AdvancementHolder alexandrite_helmet = Advancement.Builder.advancement()
                    .parent(alexandrite_chestplate)
                    .display(ModItems.ALEXANDRITE_HELMET.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_helmet.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_helmet.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("Alexandrite_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_HELMET.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_helmet"));

            AdvancementHolder alexandrite_full_armour = Advancement.Builder.advancement()
                    .parent(alexandrite_helmet)
                    .display(ModItems.ALEXANDRITE_CHESTPLATE.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_full_armour.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_full_armour.description"),
                            null,
                            AdvancementType.CHALLENGE, true, true, false)
                    .addCriterion("Alexandrite_full_armour", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_BOOTS.get(), ModItems.ALEXANDRITE_LEGGINGS.get(), ModItems.ALEXANDRITE_CHESTPLATE.get(), ModItems.ALEXANDRITE_HELMET.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_full_armour"));

            AdvancementHolder kaupen_smithing_template = Advancement.Builder.advancement()
                    .parent(alexandrite_full_armour)
                    .display(ModItems.KAUPEN_SMITHING_TEMPLATE.get(),
                            Component.translatable("advancements.alexandrite.kaupen_smithing_template.title"),
                            Component.translatable("advancements.alexandrite.kaupen_smithing_template.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("kaupen_smithing_template", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.KAUPEN_SMITHING_TEMPLATE.get()))
                   .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/kaupen_smithing_template"));


            AdvancementHolder alexandrite_pickaxe = Advancement.Builder.advancement()
                    .parent(alexandrite2)
                    .display(ModItems.ALEXANDRITE_PICKAXE.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_pickaxe.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_pickaxe.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("AlexandritePickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_PICKAXE.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_pickaxe"));

            AdvancementHolder alexandrite_hammer = Advancement.Builder.advancement()
                    .parent(alexandrite_pickaxe)
                    .display(ModItems.ALEXANDRITE_HAMMER.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_hammer.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_hammer.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("AlexandriteHammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_HAMMER.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_hammer"));

            AdvancementHolder alexandrite_sword = Advancement.Builder.advancement()
                    .parent(alexandrite_pickaxe)
                    .display(ModItems.ALEXANDRITE_SWORD.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_sword.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_sword.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("AlexandriteSword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_SWORD.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_sword"));

            AdvancementHolder alexandrite_axe = Advancement.Builder.advancement()
                    .parent(alexandrite_sword)
                    .display(ModItems.ALEXANDRITE_AXE.get(),
                            Component.translatable("advancements.alexandrite.alexandrite_axe.title"),
                            Component.translatable("advancements.alexandrite.alexandrite_axe.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("AlexandriteAxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ALEXANDRITE_AXE.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/alexandrite_axe"));

            AdvancementHolder kaupen_bow = Advancement.Builder.advancement()
                    .parent(alexandrite_sword)
                    .display(ModItems.KAUPEN_BOW.get(),
                            Component.translatable("advancements.alexandrite.kaupen_bow.title"),
                            Component.translatable("advancements.alexandrite.kaupen_bow.description"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("KaupenBow", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.KAUPEN_BOW.get()))
                    .save(consumer, ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "alexandrite/kaupen_bow"));
        }
    }
}
