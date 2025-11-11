package com.msg.combining_gears.items;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.msg.combining_gears.Common;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class LeathererBoots extends ArmorItem {
    public LeathererBoots(String name, int defense, int enchantmentValue, Holder<SoundEvent> sound, ItemLike repairItem, int toughness, int knockbackResistance, Properties properties) {
        super(Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                        Common.resourcesLocation(name),
                                                                        new ArmorMaterial(
                                                                            new EnumMap<>(Map.of(ArmorItem.Type.BOOTS, defense)),
                                                                            enchantmentValue,
                                                                            sound,
                                                                            () -> Ingredient.of(repairItem, Items.LEATHER),
                                                                            List.of(new ArmorMaterial.Layer(Common.resourcesLocation(name))),
                                                                            toughness,
                                                                            knockbackResistance
                                                                        )
                                                                    ),
                                            ArmorItem.Type.BOOTS,
                                            properties);
    }

    public static boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
