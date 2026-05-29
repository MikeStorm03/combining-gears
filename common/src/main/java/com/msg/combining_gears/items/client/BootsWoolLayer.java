package com.msg.combining_gears.items.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class BootsWoolLayer extends HumanoidArmorModel<LivingEntity> {

	public BootsWoolLayer(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
    	CubeDeformation cubeDeformation1 = new CubeDeformation(1.25F, 0.375F, 1.25F);
		MeshDefinition humanoidDefinition = HumanoidModel.createMesh(new CubeDeformation(1.0F), 0.0F);
		
      	PartDefinition partDefinition = humanoidDefinition.getRoot();

		partDefinition.addOrReplaceChild("right_leg",
										CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, 5.8F, -2.0F, 4.0F, 1.0F, 4.0F, cubeDeformation1),
										PartPose.offset(-1.9F, 12.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_leg",
										CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, 5.8F, -2.0F, 4.0F, 1.0F, 4.0F, cubeDeformation1),
										PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(humanoidDefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}