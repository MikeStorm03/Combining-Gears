package com.msg.combining_gears.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.msg.combining_gears.Constants;
import com.msg.combining_gears.items.ElytraChestplate;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Mixin(Player.class)
public class PlayerMixinFabric {
    @Redirect(method = "Lnet/minecraft/world/entity/player/Player;tryToStartFallFlying()Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean checkItem(ItemStack itemStack, Item item) {
        return itemStack.is(item) || itemStack.is(Constants.elytraChestplate);
    }

    @Redirect(method = "Lnet/minecraft/world/entity/player/Player;tryToStartFallFlying()Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ElytraItem;isFlyEnabled(Lnet/minecraft/world/item/ItemStack;)Z"))
    private static boolean checkDurability(ItemStack itemStack) {
        return ElytraItem.isFlyEnabled(itemStack) || ElytraChestplate.isFlyEnabled(itemStack);
    }
}
