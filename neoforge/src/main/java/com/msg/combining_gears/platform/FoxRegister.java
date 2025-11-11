package com.msg.combining_gears.platform;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.msg.combining_gears.Constants;
import com.msg.combining_gears.items.Gears;
import com.msg.combining_gears.registers.RegistryHelper;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FoxRegister{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Constants.NAMESPACE);
    public static final DeferredRegister<Item> BACKPORT_GEARS = DeferredRegister.create(Registries.ITEM, "minecraft");
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "minecraft");

    public static <T> void registry(IEventBus eventBus, DeferredRegister<T> register, RegistryHelper<T> helper){
        Map<String, Supplier<T>> suppilers = helper.getSuppiers();
        Set<String> names = suppilers.keySet();
        for (String name : names) helper.getSuppiers().put(name, register.register(name, suppilers.get(name)));
        register.register(eventBus);
    }

    public static void registerSound(IEventBus eventBus) {
        Gears.EQUIP_COPPER_SOUND.getSuppiers().forEach((name, supplier) -> {
            Holder<SoundEvent> holder = SOUND_EVENTS.register(name, n -> supplier.get().value());
            Gears.EQUIP_COPPER_SOUND.getSuppiers().put(name, () -> holder);
        });
        SOUND_EVENTS.register(eventBus);
    }
}