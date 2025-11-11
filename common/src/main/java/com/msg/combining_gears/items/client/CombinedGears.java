package com.msg.combining_gears.items.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.msg.combining_gears.Common;

import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class CombinedGears extends HumanoidArmorModel<LivingEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Common.resourcesLocation("combined_gears"), "combined_gears");

	public CombinedGears(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
    	CubeDeformation cubeDeformation1 = new CubeDeformation(1.25F, 0.375F, 1.25F);
    	CubeDeformation cubeDeformation2 = new CubeDeformation(1.0F);
		MeshDefinition humanoidDefinition = HumanoidModel.createMesh(cubeDeformation2, 0.0F);
		
      	PartDefinition partDefinition = humanoidDefinition.getRoot();
		
		partDefinition.getChild("right_leg").addOrReplaceChild("right_leg",
															CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -6.8F, -2.0F, 4.0F, 1.0F, 4.0F, cubeDeformation1),
															PartPose.offset(-1.9F, 12.0F, 0.0F));
      	partDefinition.getChild("left_leg").addOrReplaceChild("left_leg",
															CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-4.0F, -6.8F, -2.0F, 4.0F, 1.0F, 4.0F, cubeDeformation1),
															PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(humanoidDefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {

		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);

	}
}