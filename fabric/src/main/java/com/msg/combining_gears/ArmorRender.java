package com.msg.combining_gears;


import com.mojang.blaze3d.vertex.PoseStack;
import com.msg.combining_gears.items.client.BootsWoolLayer;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.component.DyedItemColor;

public class ArmorRender implements ArmorRenderer{

    private final HumanoidArmorModel<LivingEntity> model;
    private final BootsWoolLayer woolModel;
    private final ResourceLocation textureLocation;
    private final ResourceLocation overlayLocation;

    public ArmorRender(String textureName) {
        this.model = new HumanoidArmorModel<LivingEntity>(HumanoidArmorModel.createBodyLayer(new CubeDeformation(1.0F)).getRoot().bake(64, 32));
        this.woolModel = new BootsWoolLayer(BootsWoolLayer.createBodyLayer().bakeRoot());
        this.textureLocation = Common.resourcesLocation("textures/models/armor/" + textureName + ".png");
        this.overlayLocation = Common.resourcesLocation("textures/models/armor/" + textureName + "_overlay.png");
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, HumanoidModel<LivingEntity> contextModel) {

        model.setAllVisible(false);
        model.young = contextModel.young;
        model.crouching = contextModel.crouching;
        
        woolModel.setAllVisible(false);
        woolModel.young = contextModel.young;
        woolModel.crouching = contextModel.crouching;
     
        switch (slot) {
            case EquipmentSlot.HEAD:

                model.head.visible = true;
                model.hat.visible = true;
                model.head.copyFrom(contextModel.head);
                model.hat.copyFrom(contextModel.hat);

                break;

            case EquipmentSlot.CHEST:
            
                model.body.visible = true;
                model.leftArm.visible = true;
                model.rightArm.visible = true;

                model.body.copyFrom(contextModel.body);
                model.leftArm.copyFrom(contextModel.leftArm);
                model.rightArm.copyFrom(contextModel.rightArm);

                break;

            case EquipmentSlot.FEET:
            
                model.leftLeg.visible = true;
                model.rightLeg.visible = true;

                woolModel.leftLeg.visible = true;
                woolModel.rightLeg.visible = true;

                model.leftLeg.copyFrom(contextModel.leftLeg);
                model.rightLeg.copyFrom(contextModel.rightLeg);

                woolModel.leftLeg.copyFrom(contextModel.leftLeg);
                woolModel.rightLeg.copyFrom(contextModel.rightLeg);

                break;

        }

        if (stack.is(ItemTags.DYEABLE)) {
            model.renderToBuffer(poseStack,
                                ItemRenderer.getArmorFoilBuffer(vertexConsumers,
                                                                RenderType.armorCutoutNoCull(this.textureLocation),
                                                                stack.hasFoil()),
                                light,
                                OverlayTexture.WHITE_OVERLAY_V,
                                DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR));
            ArmorRenderer.renderPart(poseStack, vertexConsumers, light, stack, model, this.overlayLocation);
            ArmorRenderer.renderPart(poseStack, vertexConsumers, light, stack, woolModel,
                ResourceLocation.withDefaultNamespace("textures/block/" + stack.get(Constants.LEATHERER_BOOTS_WOOL).getName() + "_wool.png"));
        } else ArmorRenderer.renderPart(poseStack, vertexConsumers, light, stack, model, this.textureLocation);

        ArmorTrim trim = stack.get(DataComponents.TRIM);
        if (trim != null) {
            model.renderToBuffer(poseStack,
                            Minecraft.getInstance().getModelManager()
                                                .getAtlas(Sheets.ARMOR_TRIMS_SHEET)
                                                .getSprite(trim.outerTexture(((ArmorItem)stack.getItem()).getMaterial()))
                                                .wrap(vertexConsumers.getBuffer(RenderType.createArmorDecalCutoutNoCull(Sheets.ARMOR_TRIMS_SHEET))),
                            light,
                            OverlayTexture.NO_OVERLAY);
        }

    }

}