package com.msg.combining_gears.mixin;

import java.util.EnumMap;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.Util;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterials;

@Mixin(ArmorMaterials.class)
public class ArmorMaterialsMixin {

    @ModifyArgs(
        method = "<clinit>",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ArmorMaterials;register(Ljava/lang/String;Ljava/util/EnumMap;ILnet/minecraft/core/Holder;FFLjava/util/function/Supplier;)Lnet/minecraft/core/Holder;"
        )
    )
    private static void inject(Args args) {
        if (args.get(0) == "netherite") args.set(1, (EnumMap)Util.make(new EnumMap(Type.class), (enumMap) -> {
            enumMap.put(Type.BOOTS, 3);
            enumMap.put(Type.LEGGINGS, 6);
            enumMap.put(Type.CHESTPLATE, 8);
            enumMap.put(Type.HELMET, 3);
            enumMap.put(Type.BODY, 19);
        }));
    }
}