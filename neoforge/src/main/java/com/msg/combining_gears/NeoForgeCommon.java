package com.msg.combining_gears;

import com.msg.combining_gears.items.Gears;

import net.minecraft.core.Registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.NAMESPACE)
public class NeoForgeCommon {

    public NeoForgeCommon() {
        Common.init();
    }

    @SubscribeEvent
    public static void registerSetup(RegisterEvent event) {
        Registry<?> registry = event.getRegistry();
        if (registry.equals(BuiltInRegistries.ITEM)) Gears.init();
    }
}