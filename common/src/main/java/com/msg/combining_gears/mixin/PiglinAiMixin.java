package com.msg.combining_gears.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.msg.combining_gears.Constants;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;

@Mixin(PiglinAi.class)
public class PiglinAiMixin {

    /* compare armor materials
    @Redirect(
        method = "isWearingGold",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Holder;is(Lnet/minecraft/core/Holder;)Z")
    )
    private static boolean injection(Holder<ArmorMaterial> armorMaterialHolder, Holder<ArmorMaterial> goldMaterialHolder){
        return armorMaterialHolder.is(goldMaterialHolder);
    }
    */

    @Redirect(
        method = "isWearingGold",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ArmorItem;getMaterial()Lnet/minecraft/core/Holder;")
    )
    private static Holder<ArmorMaterial> injection(ArmorItem armor){
        return (new ItemStack(armor)).is(Constants.goldArmor) ? ArmorMaterials.GOLD : armor.getMaterial();
    }
}
