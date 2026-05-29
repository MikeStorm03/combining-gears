package com.msg.combining_gears;

import com.msg.combining_gears.items.Gears;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class FabricCommon implements ModInitializer {

    public static final TagKey<Item> leathererBoots = TagKey.create(Registries.ITEM, Common.resourcesLocation("leatherer_boots"));
    // private static final Map<ResourceLocation, JsonElement> CACHE = new HashMap<>();

    @Override
    public void onInitialize() {

        Common.init();
        Gears.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Items.LEATHER_BOOTS, Gears.COPPER_HELMET, Gears.COPPER_CHESTPLATE, Gears.COPPER_LEGGINGS, Gears.COPPER_BOOTS));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Gears.COPPER_HELMET, Gears.COPPER_CHESTPLATE));
        //, Gears.COPPER_LEGGINGS, Gears.COPPER_BOOTS
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Items.LEATHER_HORSE_ARMOR, Gears.COPPER_HORSE_ARMOR));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_HORSE_ARMOR, Gears.NETHER_HORSE_ARMOR));

        ResourceManagerHelperImpl.registerBuiltinResourcePack(Common.resourcesLocation("backport_gears"),
                                                                                "datapacks/backport_gears",
                                                                                FabricLoader.getInstance().getModContainer(Constants.NAMESPACE).orElseThrow(),
                                                                                Component.translatable("datapack.backport_gears"),
                                                                                ResourcePackActivationType.NORMAL);
    }
}
