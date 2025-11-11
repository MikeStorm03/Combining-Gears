package com.msg.combining_gears;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class Constants {

	public static final String NAMESPACE = "combining_gears";
	public static final String MOD_NAME = "Combining Gears";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	// Item tags
    public static final TagKey<Item> turtleHelmets = TagKey.create(Registries.ITEM, Common.resourcesLocation("turtle_helmets"));
    public static final TagKey<Item> elytraChestplate = TagKey.create(Registries.ITEM, Common.resourcesLocation("elytra_chestplates"));
}