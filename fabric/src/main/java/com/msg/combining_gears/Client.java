package com.msg.combining_gears;

import com.msg.combining_gears.items.Gears;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ColorProviderRegistry.ITEM.register((ItemStack stack, int tintIndex) -> {
            if (tintIndex != 0) return -1;
            return DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR);
        }, Gears.TURTLE_LEATHER.get(), Gears.ELYTRA_LEATHER.get(), Gears.LEATHER_COPPER.get(), Gears.LEATHER_CHAIN.get(), Gears.LEATHER_IRON.get(), Gears.LEATHER_GOLD.get(), Gears.LEATHER_DIAMOND.get(), Gears.LEATHER_NETHER.get());

        ArmorRenderer.register(new ArmorRender("leather"), Gears.TURTLE_LEATHER.get());
        ArmorRenderer.register(new ArmorRender("leather"), Gears.ELYTRA_LEATHER.get());

        ArmorRenderer.register(new ArmorRender("copper"), Gears.TURTLE_COPPER.get());
        ArmorRenderer.register(new ArmorRender("copper"), Gears.ELYTRA_COPPER.get());
        ArmorRenderer.register(new ArmorRender("copper"), Gears.LEATHER_COPPER.get());

        ArmorRenderer.register(new ArmorRender("chainmail"), Gears.TURTLE_CHAIN.get());
        ArmorRenderer.register(new ArmorRender("chainmail"), Gears.ELYTRA_CHAIN.get());
        ArmorRenderer.register(new ArmorRender("chainmail"), Gears.LEATHER_CHAIN.get());

        ArmorRenderer.register(new ArmorRender("iron"), Gears.TURTLE_IRON.get());
        ArmorRenderer.register(new ArmorRender("iron"), Gears.ELYTRA_IRON.get());
        ArmorRenderer.register(new ArmorRender("iron"), Gears.LEATHER_IRON.get());

        ArmorRenderer.register(new ArmorRender("gold"), Gears.TURTLE_GOLD.get());
        ArmorRenderer.register(new ArmorRender("gold"), Gears.ELYTRA_GOLD.get());
        ArmorRenderer.register(new ArmorRender("gold"), Gears.LEATHER_GOLD.get());

        ArmorRenderer.register(new ArmorRender("diamond"), Gears.TURTLE_DIAMOND.get());
        ArmorRenderer.register(new ArmorRender("diamond"), Gears.ELYTRA_DIAMOND.get());
        ArmorRenderer.register(new ArmorRender("diamond"), Gears.LEATHER_DIAMOND.get());

        ArmorRenderer.register(new ArmorRender("netherite"), Gears.TURTLE_NETHER.get());
        ArmorRenderer.register(new ArmorRender("netherite"), Gears.ELYTRA_NETHER.get());
        ArmorRenderer.register(new ArmorRender("netherite"), Gears.LEATHER_NETHER.get());
    }

}
