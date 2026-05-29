package com.msg.combining_gears.items;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class CopperMaterial {
    public static final Holder<ArmorMaterial> MATERIAL = Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                            ResourceLocation.withDefaultNamespace("copper"),
                                                                            new ArmorMaterial(new EnumMap<>(Map.of(
                                                                                Type.BOOTS, 1,
                                                                                Type.LEGGINGS, 3,
                                                                                Type.CHESTPLATE, 4,
                                                                                Type.HELMET, 1,
                                                                                Type.BODY, 4
                                                                            )),
                                                                            8,
                                                                            Gears.ARMOR_EQUIP_COPPER,
                                                                            () -> Ingredient.of(Items.COPPER_INGOT),
                                                                            List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace("copper"))),
                                                                            0,
                                                                            0));
}
