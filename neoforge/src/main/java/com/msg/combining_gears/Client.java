package com.msg.combining_gears;

import com.msg.combining_gears.items.Gears;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor.ARGB32;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@Mod(value = Constants.NAMESPACE, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Constants.NAMESPACE, value = Dist.CLIENT)
public class Client {

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ArmorRender("leather"), Gears.TURTLE_LEATHER);
    }

}
