package com.msg.combining_gears.items;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.msg.combining_gears.Common;
import com.msg.combining_gears.Constants;
import com.msg.combining_gears.registers.RegistryHelper;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.AnimalArmorItem.BodyType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

public class Gears {

    public static final RegistryHelper<Item> ITEMS = new RegistryHelper<>(Constants.NAMESPACE);
    public static final RegistryHelper<Item> BACKPORT_GEARS = new RegistryHelper<>("minecraft");
    public static final RegistryHelper<Holder<SoundEvent>> EQUIP_COPPER_SOUND = new RegistryHelper<>("minecraft");
    public static final RegistryHelper<CreativeModeTab> CREATIVE_TABS = new RegistryHelper<>(Constants.NAMESPACE);

    // Copper armor material and wearing sound
    public static final Supplier<Holder<SoundEvent>> ARMOR_EQUIP_COPPER = EQUIP_COPPER_SOUND.register("item.armor.equip_copper", () -> Holder.direct(SoundEvent.createVariableRangeEvent(ResourceLocation.withDefaultNamespace("item.armor.equip_copper"))));

    // Backport Armors
    public static final Supplier<Item> COPPER_HELMET = registerArmor("copper_helmet", ArmorItem.Type.HELMET, 121);
    public static final Supplier<Item> COPPER_CHESTPLATE = registerArmor("copper_chestplate", ArmorItem.Type.CHESTPLATE, 176);
    public static final Supplier<Item> COPPER_LEGGINGS = registerArmor("copper_leggings", ArmorItem.Type.LEGGINGS, 165);
    public static final Supplier<Item> COPPER_BOOTS = registerArmor("copper_boots", ArmorItem.Type.BOOTS, 143);
    public static final Supplier<Item> COPPER_HORSE_ARMOR = BACKPORT_GEARS.register("copper_horse_armor", () -> new AnimalArmorItem(CopperMaterial.MATERIAL, BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> NETHER_HORSE_ARMOR = BACKPORT_GEARS.register("netherite_horse_armor", () -> new AnimalArmorItem(
                                                                                                                    Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                                                                                            ResourceLocation.withDefaultNamespace("netherite"),
                                                                                                                                            new ArmorMaterial(
                                                                                                                                                new EnumMap<>(Map.of(ArmorItem.Type.BODY, 19)),
                                                                                                                                                15,
                                                                                                                                                SoundEvents.ARMOR_EQUIP_NETHERITE,
                                                                                                                                                () -> Ingredient.of(Items.NETHERITE_INGOT),
                                                                                                                                                List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace( "netherite"))),
                                                                                                                                                3,
                                                                                                                                                1
                                                                                                                                            )
                                                                                                                                        ),
                                                                                                                    BodyType.EQUESTRIAN,
                                                                                                                    false,
                                                                                                                    new Item.Properties().stacksTo(1).fireResistant()));

    // Helmets
    public static final Supplier<Item> TURTLE_LEATHER = helmet("turtle_leather", 1, 0, 0, 55, false, 15, Items.LEATHER, SoundEvents.ARMOR_EQUIP_LEATHER);
    public static final Supplier<Item> TURTLE_COPPER = helmet("turtle_copper", 2, 0, 0, 121, false, 8, Items.COPPER_INGOT, ARMOR_EQUIP_COPPER.get());
    public static final Supplier<Item> TURTLE_CHAIN = helmet("turtle_chainmail", 2, 0, 0, 165, false, 12, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_CHAIN);
    public static final Supplier<Item> TURTLE_IRON = helmet("turtle_iron", 2, 0, 0, 165, false, 9, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);
    public static final Supplier<Item> TURTLE_GOLD = helmet("turtle_gold", 2, 0, 0, 77, false, 25, Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);
    public static final Supplier<Item> TURTLE_DIAMOND = helmet("turtle_diamond", 3, 2, 0, 363, false, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Supplier<Item> TURTLE_NETHER = helmet("turtle_netherite", 3, 3, 1, 407, true, 15, Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    // Chestplates
    public static final Supplier<Item> ELYTRA_LEATHER = chestplate("elytra_leather", 3, 0, 0, 80, false, 15, Items.LEATHER, SoundEvents.ARMOR_EQUIP_LEATHER);
    public static final Supplier<Item> ELYTRA_COPPER = chestplate("elytra_copper", 4, 0, 0, 176, false, 8, Items.COPPER_INGOT, ARMOR_EQUIP_COPPER.get());
    public static final Supplier<Item> ELYTRA_CHAIN = chestplate("elytra_chainmail", 5, 0, 0, 240, false, 12, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_CHAIN);
    public static final Supplier<Item> ELYTRA_IRON = chestplate("elytra_iron", 6, 0, 0, 240, false, 9, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);
    public static final Supplier<Item> ELYTRA_GOLD = chestplate("elytra_gold", 5, 0, 0, 112, false, 25, Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);
    public static final Supplier<Item> ELYTRA_DIAMOND = chestplate("elytra_diamond", 8, 2, 0, 528, false, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Supplier<Item> ELYTRA_NETHER = chestplate("elytra_netherite", 8, 3, 1, 592, true, 15, Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    // Boots
    public static final Supplier<Item> LEATHER_COPPER = boots("leather_copper", 1, 0, 0, 143, false, 8, Items.COPPER_INGOT, ARMOR_EQUIP_COPPER.get());
    public static final Supplier<Item> LEATHER_CHAIN = boots("leather_chainmail", 1, 0, 0, 195, false, 12, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_CHAIN);
    public static final Supplier<Item> LEATHER_IRON = boots("leather_iron", 2, 0, 0, 195, false, 9, Items.IRON_INGOT, SoundEvents.ARMOR_EQUIP_IRON);
    public static final Supplier<Item> LEATHER_GOLD = boots("leather_gold", 1, 0, 0, 91, false, 25, Items.GOLD_INGOT, SoundEvents.ARMOR_EQUIP_GOLD);
    public static final Supplier<Item> LEATHER_DIAMOND = boots("leather_diamond", 3, 2, 0, 429, false, 10, Items.DIAMOND, SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Supplier<Item> LEATHER_NETHER = boots("leather_netherite", 3, 2, 0, 429, true, 10, Items.NETHERITE_INGOT, SoundEvents.ARMOR_EQUIP_NETHERITE);

    // Creative tabs
    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("itemgroup.combined_gears", () ->
                    CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                        .title(Component.translatable("itemgroup.combined_gears"))
                        .icon(() -> new ItemStack(ELYTRA_NETHER.get()))
                        .displayItems((parameters, output) -> {
                            output.accept(TURTLE_LEATHER.get());
                            output.accept(ELYTRA_LEATHER.get());
                            output.accept(TURTLE_COPPER.get());
                            output.accept(ELYTRA_COPPER.get());
                            output.accept(LEATHER_COPPER.get());
                            output.accept(TURTLE_CHAIN.get());
                            output.accept(ELYTRA_CHAIN.get());
                            output.accept(LEATHER_CHAIN.get());
                            output.accept(TURTLE_IRON.get());
                            output.accept(ELYTRA_IRON.get());
                            output.accept(LEATHER_IRON.get());
                            output.accept(TURTLE_GOLD.get());
                            output.accept(ELYTRA_GOLD.get());
                            output.accept(LEATHER_GOLD.get());
                            output.accept(TURTLE_DIAMOND.get());
                            output.accept(ELYTRA_DIAMOND.get());
                            output.accept(LEATHER_DIAMOND.get());
                            output.accept(TURTLE_NETHER.get());
                            output.accept(ELYTRA_NETHER.get());
                            output.accept(LEATHER_NETHER.get());
                        })
                        .build()
                );

    // Register
    public static final Supplier<Item> helmet(String name, int defense, int toughness, int knockbackResistance, int durability, boolean fireResistant, int enchantmentValue, Item repairItem, Holder<SoundEvent> sound) {
        return ITEMS.register(name, () -> new ArmorItem(
                                            Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                        Common.resourcesLocation(name),
                                                                        new ArmorMaterial(
                                                                            new EnumMap<>(Map.of(ArmorItem.Type.HELMET, defense)),
                                                                            enchantmentValue,
                                                                            sound,
                                                                            () -> Ingredient.of(repairItem, Items.TURTLE_SCUTE),
                                                                            List.of(new ArmorMaterial.Layer(Common.resourcesLocation(name))),
                                                                            toughness,
                                                                            knockbackResistance
                                                                        )
                                                                    ),
                                                ArmorItem.Type.HELMET,
                                                fireResistant ? new Item.Properties().durability(durability).fireResistant()
                                                                : new Item.Properties().durability(durability)));
    }

    public static final Supplier<Item> chestplate(String name, int defense, int toughness, int knockbackResistance, int durability, boolean fireResistant, int enchantmentValue, Item repairItem, Holder<SoundEvent> sound){
        return ITEMS.register(name, () -> new ElytraChestplate(name, defense, enchantmentValue, sound, repairItem, toughness, knockbackResistance,
                                                            fireResistant ? new Item.Properties().durability(durability).rarity(Rarity.UNCOMMON).fireResistant()
                                                                            : new Item.Properties().durability(durability).rarity(Rarity.UNCOMMON)));
    }

    public static final Supplier<Item> boots(String name, int defense, int toughness, int knockbackResistance, int durability, boolean fireResistant, int enchantmentValue, Item repairItem, Holder<SoundEvent> sound){
        return ITEMS.register(name, () -> new LeathererBoots(name, defense, enchantmentValue, sound, repairItem, toughness, knockbackResistance,
                                                            fireResistant ? new Item.Properties().durability(durability).rarity(Rarity.UNCOMMON).fireResistant()
                                                                            : new Item.Properties().durability(durability).rarity(Rarity.UNCOMMON)));
    }

    public static final Supplier<Item> registerArmor(String name, ArmorItem.Type type, int durability) {
        return BACKPORT_GEARS.register(name, () -> new ArmorItem(CopperMaterial.MATERIAL, type, new Item.Properties().durability(durability)));
    }
}