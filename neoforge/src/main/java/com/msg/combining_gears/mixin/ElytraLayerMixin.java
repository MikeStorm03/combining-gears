package com.msg.combining_gears.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.msg.combining_gears.Constants;

import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(ElytraLayer.class)
public class ElytraLayerMixin {
    
    @Inject(method = "Lnet/minecraft/client/renderer/entity/layers/ElytraLayer;shouldRender(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)Z",
            at = @At("HEAD"), cancellable = true)
    private void checkItem(ItemStack stack, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(Constants.elytraChestplate)) cir.setReturnValue(true);;
    }
}
