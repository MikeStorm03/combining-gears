package com.msg.combining_gears.items;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.msg.combining_gears.Common;
import com.msg.combining_gears.Constants;
import com.msg.combining_gears.enums.WoolColor;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.AnimalArmorItem.BodyType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

public class Gears {

    // Copper armor material and wearing sound
    public static final Holder<SoundEvent> ARMOR_EQUIP_COPPER = Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, ResourceLocation.withDefaultNamespace("item.armor.equip_copper"), SoundEvent.createVariableRangeEvent(ResourceLocation.withDefaultNamespace("item.armor.equip_copper")));

    // Backport Armors
    public static final Item COPPER_HELMET = registerArmor("copper_helmet", ArmorItem.Type.HELMET, 121);
    public static final Item COPPER_CHESTPLATE = registerArmor("copper_chestplate", ArmorItem.Type.CHESTPLATE, 176);
    public static final Item COPPER_LEGGINGS = registerArmor("copper_leggings", ArmorItem.Type.LEGGINGS, 165);
    public static final Item COPPER_BOOTS = registerArmor("copper_boots", ArmorItem.Type.BOOTS, 143);
    public static final Item COPPER_HORSE_ARMOR = Registry.register(BuiltInRegistries.ITEM,
                                                                    ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.withDefaultNamespace("copper_horse_armor")),
                                                                    new AnimalArmorItem(CopperMaterial.MATERIAL, BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));
    public static final Item NETHER_HORSE_ARMOR = Registry.register(BuiltInRegistries.ITEM,
                                                                    ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.withDefaultNamespace("netherite_horse_armor")),
                                                                    new AnimalArmorItem(ArmorMaterials.NETHERITE, BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1).fireResistant()));

    // Helmets
    public static final Item TURTLE_LEATHER = helmet("turtle_leather", 1, 0, 0, 55, false, 15, Items.LEATHER, SoundEvents.ARMOR_EQUIP_LEATHER);
    public static final Item TURTLE_COPPER = helmet("turtle_copper", 2, 0, 0, 121, false, 8, Items.COPPER_INGOT, ARMOR_EQUIP_COPPER);
    public static final Item TURTLE_CHAIN = helmet("turtle_chainmail", 2, 0, 0, 165, false, 12, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_CHAIN);
    public static final Item TURTLE_IRON = helmet("turtle_iron", 2, 0, 0, 165, false, 9, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);
    public static final Item TURTLE_GOLD = helmet("turtle_gold", 2, 0, 0, 77, false, 25, Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);
    public static final Item TURTLE_DIAMOND = helmet("turtle_diamond", 3, 2, 0, 363, false, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Item TURTLE_NETHER = helmet("turtle_netherite", 3, 3, 0.1F, 407, true, 15, Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    // Chestplates
    public static final Item ELYTRA_LEATHER = chestplate("elytra_leather", 3, 0, 0, 80, false, 15, Items.LEATHER, SoundEvents.ARMOR_EQUIP_LEATHER);
    public static final Item ELYTRA_COPPER = chestplate("elytra_copper", 4, 0, 0, 176, false, 8, Items.COPPER_INGOT, ARMOR_EQUIP_COPPER);
    public static final Item ELYTRA_CHAIN = chestplate("elytra_chainmail", 5, 0, 0, 240, false, 12, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_CHAIN);
    public static final Item ELYTRA_IRON = chestplate("elytra_iron", 6, 0, 0, 240, false, 9, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);
    public static final Item ELYTRA_GOLD = chestplate("elytra_gold", 5, 0, 0, 112, false, 25, Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);
    public static final Item ELYTRA_DIAMOND = chestplate("elytra_diamond", 8, 2, 0, 528, false, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Item ELYTRA_NETHER = chestplate("elytra_netherite", 8, 3, 0.1F, 592, true, 15, Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    // Boots
    public static final Item LEATHER_COPPER = boots("leather_copper", 1, 0, 0, 143, false, 8, Items.COPPER_INGOT, ARMOR_EQUIP_COPPER);
    public static final Item LEATHER_CHAIN = boots("leather_chainmail", 1, 0, 0, 195, false, 12, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_CHAIN);
    public static final Item LEATHER_IRON = boots("leather_iron", 2, 0, 0, 195, false, 9, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);
    public static final Item LEATHER_GOLD = boots("leather_gold", 1, 0, 0, 91, false, 25, Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);
    public static final Item LEATHER_DIAMOND = boots("leather_diamond", 3, 2, 0, 429, false, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Item LEATHER_NETHER = boots("leather_netherite", 3, 2, 0.1F, 429, true, 10, Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    // Creative tabs
    public static final CreativeModeTab CREATIVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                                                                        Common.resourcesLocation("combined_gears"),
                                                                        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                                                                            .title(Component.translatable("itemgroup.combined_gears"))
                                                                            .icon(() -> new ItemStack(ELYTRA_NETHER))
                                                                            .displayItems((parameters, output) -> {
                                                                                output.accept(TURTLE_LEATHER);
                                                                                output.accept(ELYTRA_LEATHER);
                                                                                output.accept(TURTLE_COPPER);
                                                                                output.accept(ELYTRA_COPPER);
                                                                                output.accept(LEATHER_COPPER);
                                                                                output.accept(TURTLE_CHAIN);
                                                                                output.accept(ELYTRA_CHAIN);
                                                                                output.accept(LEATHER_CHAIN);
                                                                                output.accept(TURTLE_IRON);
                                                                                output.accept(ELYTRA_IRON);
                                                                                output.accept(LEATHER_IRON);
                                                                                output.accept(TURTLE_GOLD);
                                                                                output.accept(ELYTRA_GOLD);
                                                                                output.accept(LEATHER_GOLD);
                                                                                output.accept(TURTLE_DIAMOND);
                                                                                output.accept(ELYTRA_DIAMOND);
                                                                                output.accept(LEATHER_DIAMOND);
                                                                                output.accept(TURTLE_NETHER);
                                                                                output.accept(ELYTRA_NETHER);
                                                                                output.accept(LEATHER_NETHER);
                                                                            })
                                                                            .build());

    // Register
    public static final Item helmet(String name, int defense, int toughness, float knockbackResistance, int durability, boolean fireResistant, int enchantmentValue, Item repairItem, Holder<SoundEvent> sound) {
        return Registry.register(BuiltInRegistries.ITEM,
                                Common.resourcesLocation(name),
                                new ArmorItem(Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                        Common.resourcesLocation(name),
                                                                        new ArmorMaterial(
                                                                            new EnumMap<>(Map.of(ArmorItem.Type.HELMET, defense)),
                                                                            enchantmentValue,
                                                                            sound,
                                                                            () -> Ingredient.of(repairItem, Items.TURTLE_SCUTE),
                                                                            List.of(new ArmorMaterial.Layer(Common.resourcesLocation(name))),
                                                                            toughness,
                                                                            knockbackResistance
                                                                        )
                                                                    ),
                                                ArmorItem.Type.HELMET,
                                                fireResistant ? new Item.Properties().durability(durability).fireResistant()
                                                                : new Item.Properties().durability(durability)));
    }

    public static final Item chestplate(String name, int defense, int toughness, float knockbackResistance, int durability, boolean fireResistant, int enchantmentValue, Item repairItem, Holder<SoundEvent> sound){
        return Registry.register(BuiltInRegistries.ITEM,
                                Common.resourcesLocation(name),
                                new ElytraChestplate(name,
                                                    defense,
                                                    enchantmentValue,
                                                    sound,
                                                    repairItem,
                                                    toughness,
                                                    knockbackResistance,
                                                    fireResistant ? new Item.Properties().durability(durability).rarity(Rarity.UNCOMMON).fireResistant()
                                                                : new Item.Properties().durability(durability).rarity(Rarity.UNCOMMON)));
    }

    public static final Item boots(String name, int defense, int toughness, float knockbackResistance, int durability, boolean fireResistant, int enchantmentValue, Item repairItem, Holder<SoundEvent> sound){
        return Registry.register(BuiltInRegistries.ITEM, Common.resourcesLocation(name), new LeathererBoots(name, defense, enchantmentValue, sound, repairItem, toughness, knockbackResistance,
                                                            fireResistant ? new Item.Properties().durability(durability).fireResistant().component(Constants.LEATHERER_BOOTS_WOOL, WoolColor.WHITE)
                                                                            : new Item.Properties().durability(durability).component(Constants.LEATHERER_BOOTS_WOOL, WoolColor.WHITE)));
    }

    public static final Item registerArmor(String name, ArmorItem.Type type, int durability) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.withDefaultNamespace(name), new ArmorItem(CopperMaterial.MATERIAL, type, new Item.Properties().durability(durability)));
    }

    public static final void init(){}
}