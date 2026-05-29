package com.msg.combining_gears;

import com.msg.combining_gears.items.Gears;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ColorProviderRegistry.ITEM.register((ItemStack stack, int tintIndex) -> {
            if (tintIndex != 0) return -1;
            return DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR);
        }, Gears.TURTLE_LEATHER, Gears.ELYTRA_LEATHER, Gears.LEATHER_COPPER, Gears.LEATHER_CHAIN, Gears.LEATHER_IRON, Gears.LEATHER_GOLD, Gears.LEATHER_DIAMOND, Gears.LEATHER_NETHER);

        ArmorRenderer.register(new ArmorRender("leather"), Gears.TURTLE_LEATHER);
        ArmorRenderer.register(new ArmorRender("leather"), Gears.ELYTRA_LEATHER);

        ArmorRenderer.register(new ArmorRender("copper"), Gears.TURTLE_COPPER);
        ArmorRenderer.register(new ArmorRender("copper"), Gears.ELYTRA_COPPER);
        ArmorRenderer.register(new ArmorRender("copper"), Gears.LEATHER_COPPER);

        ArmorRenderer.register(new ArmorRender("chainmail"), Gears.TURTLE_CHAIN);
        ArmorRenderer.register(new ArmorRender("chainmail"), Gears.ELYTRA_CHAIN);
        ArmorRenderer.register(new ArmorRender("chainmail"), Gears.LEATHER_CHAIN);

        ArmorRenderer.register(new ArmorRender("iron"), Gears.TURTLE_IRON);
        ArmorRenderer.register(new ArmorRender("iron"), Gears.ELYTRA_IRON);
        ArmorRenderer.register(new ArmorRender("iron"), Gears.LEATHER_IRON);

        ArmorRenderer.register(new ArmorRender("gold"), Gears.TURTLE_GOLD);
        ArmorRenderer.register(new ArmorRender("gold"), Gears.ELYTRA_GOLD);
        ArmorRenderer.register(new ArmorRender("gold"), Gears.LEATHER_GOLD);

        ArmorRenderer.register(new ArmorRender("diamond"), Gears.TURTLE_DIAMOND);
        ArmorRenderer.register(new ArmorRender("diamond"), Gears.ELYTRA_DIAMOND);
        ArmorRenderer.register(new ArmorRender("diamond"), Gears.LEATHER_DIAMOND);

        ArmorRenderer.register(new ArmorRender("netherite"), Gears.TURTLE_NETHER);
        ArmorRenderer.register(new ArmorRender("netherite"), Gears.ELYTRA_NETHER);
        ArmorRenderer.register(new ArmorRender("netherite"), Gears.LEATHER_NETHER);
    }

}
