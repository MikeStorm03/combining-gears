package com.msg.combining_gears.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.msg.combining_gears.Constants;

import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Mixin(ElytraLayer.class)
public class ElytraLayerMixin {
    
    @Redirect(method = "Lnet/minecraft/client/renderer/entity/layers/ElytraLayer;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean checkItem(ItemStack itemStack, Item item) {
        return itemStack.is(item) || itemStack.is(Constants.elytraChestplate);
    }
}
