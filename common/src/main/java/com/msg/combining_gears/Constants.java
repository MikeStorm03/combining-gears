package com.msg.combining_gears;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msg.combining_gears.crafting_recipe_types.WoolChanging;
import com.msg.combining_gears.enums.WoolColor;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public interface Constants {

	String NAMESPACE = "combining_gears";
	String MOD_NAME = "Combining Gears";
	Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	// Item tags
	TagKey<Item> goldArmor = TagKey.create(Registries.ITEM, Common.resourcesLocation("gold_armor"));
    TagKey<Item> turtleHelmets = TagKey.create(Registries.ITEM, Common.resourcesLocation("turtle_helmets"));
    TagKey<Item> elytraChestplate = TagKey.create(Registries.ITEM, Common.resourcesLocation("elytra_chestplates"));
    TagKey<Item> leathererBoots = TagKey.create(Registries.ITEM, Common.resourcesLocation("leatherer_boots"));

	// Recipe Serializer
	RecipeSerializer<WoolChanging> WOOL_CHANGING_RECIPE = RecipeSerializer.register("crafting_special_wool_change", new SimpleCraftingRecipeSerializer<>(WoolChanging::new));

	// Data Component Type
	DataComponentType<WoolColor> LEATHERER_BOOTS_WOOL = Registry.register(
		BuiltInRegistries.DATA_COMPONENT_TYPE,
		ResourceLocation.fromNamespaceAndPath(NAMESPACE, "leatherer_boots_wool"),
		DataComponentType.<WoolColor>builder().persistent(WoolColor.CODEC).networkSynchronized(WoolColor.STREAM_CODEC).build()
	);

}