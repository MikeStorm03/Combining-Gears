package com.msg.combining_gears.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.msg.combining_gears.FabricCommon;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.PowderSnowBlock;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {
    @Redirect(method = "Lnet/minecraft/world/level/block/PowderSnowBlock;canEntityWalkOnPowderSnow(Lnet/minecraft/world/entity/Entity;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean checkItem(ItemStack itemStack, Item item) {
        return itemStack.is(item) || itemStack.is(FabricCommon.leathererBoots);
    }
}
