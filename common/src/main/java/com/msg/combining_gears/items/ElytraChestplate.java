package com.msg.combining_gears.items;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.msg.combining_gears.Common;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.gameevent.GameEvent;

public class ElytraChestplate extends ArmorItem {

    public ElytraChestplate(String name, int defense, int enchantmentValue, Holder<SoundEvent> sound, ItemLike repairItem, int toughness, float knockbackResistance, Properties properties) {
        super(Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                        Common.resourcesLocation(name),
                                                                        new ArmorMaterial(
                                                                            new EnumMap<>(Map.of(ArmorItem.Type.CHESTPLATE, defense)),
                                                                            enchantmentValue,
                                                                            sound,
                                                                            () -> Ingredient.of(repairItem, Items.PHANTOM_MEMBRANE),
                                                                            List.of(new ArmorMaterial.Layer(Common.resourcesLocation(name))),
                                                                            toughness,
                                                                            knockbackResistance
                                                                        )
                                                                    ),
                ArmorItem.Type.CHESTPLATE,
                properties);
    }

    public boolean canElytraFly(ItemStack itemStack, LivingEntity entity) {
        return isFlyEnabled(itemStack);
    }

    public static boolean isFlyEnabled(ItemStack itemStack) {
        return itemStack.getDamageValue() < itemStack.getMaxDamage() - 1;
    }

    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                stack.hurtAndBreak(1, entity, EquipmentSlot.CHEST);
                }

                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }

        return true;
    }
}
