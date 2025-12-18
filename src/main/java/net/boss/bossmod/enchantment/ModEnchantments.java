package net.boss.bossmod.enchantment;

import net.boss.bossmod.BossMod;
import net.boss.bossmod.enchantment.custom.ExplosiveEnchantmentEffect;
import net.boss.bossmod.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.boss.bossmod.item.ModItems;
import net.boss.bossmod.util.ModTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> LIGHTNING_STRIKER = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "lightning_striker"));
    public static final ResourceKey<Enchantment> EXPLOSIVE = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "explosive"));
    public static final ResourceKey<Enchantment> TUNNEL = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(BossMod.MOD_ID, "tunnel"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, LIGHTNING_STRIKER, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        3,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new LightningStrikerEnchantmentEffect()));

        register(context, EXPLOSIVE, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.BOW_ENCHANTABLE),
                        6,
                        3,
                        Enchantment.dynamicCost(7, 9),
                        Enchantment.dynamicCost(35, 9),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new ExplosiveEnchantmentEffect()));

        register(context, TUNNEL, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                        items.getOrThrow(ModTags.Items.HAMMER_PICKAXE),
                        //HolderSet.direct(),
                        10,
                        3,
                        Enchantment.dynamicCost(10, 10),
                        Enchantment.dynamicCost(35, 11),
                        5,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.MINING_EXCLUSIVE))
        );
    }

private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}