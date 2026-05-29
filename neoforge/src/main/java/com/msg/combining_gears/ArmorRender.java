package com.msg.combining_gears;

import org.jetbrains.annotations.NotNull;

import com.msg.combining_gears.items.client.CombinedGears;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor.ARGB32;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class ArmorRender implements IClientItemExtensions {

    private final CombinedGears model;
    private final ResourceLocation textureLocation;
    private final ResourceLocation overlayLocation;

    public ArmorRender(String textureName) {
        this.model = new CombinedGears(CombinedGears.createBodyLayer().bakeRoot(), textureName);
        this.textureLocation = Common.resourcesLocation("textures/models/armor/" + textureName + ".png");
        this.overlayLocation = Common.resourcesLocation("textures/models/armor/" + textureName + "_overlay.png");}

    @Override
    public @NotNull CombinedGears getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
        model.crouching = original.crouching;
        model.young = original.young;
        return model;
    }
}
