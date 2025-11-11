package com.msg.combining_gears;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.msg.combining_gears.items.Gears;
import com.msg.combining_gears.platform.FabricRegister;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class FabricCommon implements ModInitializer {

    public static final TagKey<Item> leathererBoots = TagKey.create(Registries.ITEM, Common.resourcesLocation("leatherer_boots"));
    private static final Map<ResourceLocation, JsonElement> CACHE = new HashMap<>();

    @Override
    public void onInitialize() {

        Common.init();
        FabricRegister.registerSound();
        FabricRegister.registry(Gears.ITEMS, BuiltInRegistries.ITEM);
        FabricRegister.registry(Gears.BACKPORT_GEARS, BuiltInRegistries.ITEM);
        FabricRegister.registry(Gears.CREATIVE_TABS, BuiltInRegistries.CREATIVE_MODE_TAB);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Items.LEATHER_BOOTS, Gears.COPPER_HELMET.get(), Gears.COPPER_CHESTPLATE.get(), Gears.COPPER_LEGGINGS.get(), Gears.COPPER_BOOTS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Items.LEATHER_HORSE_ARMOR, Gears.COPPER_HORSE_ARMOR.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((itemGroup) -> itemGroup.addAfter(Items.DIAMOND_HORSE_ARMOR, Gears.NETHER_HORSE_ARMOR.get()));

        ResourceManagerHelperImpl.registerBuiltinResourcePack(Common.resourcesLocation("backport_gears"),
                                                                                "datapacks/backport_gears",
                                                                                FabricLoader.getInstance().getModContainer(Constants.NAMESPACE).orElseThrow(),
                                                                                Component.translatable("datapack.backport_gears"),
                                                                                ResourcePackActivationType.NORMAL);

    }
}
