package com.msg.combining_gears.platform;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.msg.combining_gears.items.Gears;
import com.msg.combining_gears.registers.RegistryHelper;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class FabricRegister{

    public static <T> void registry(RegistryHelper<T> helper, Registry<T> registry) {
        Map<String, Supplier<T>> suppilers = helper.getSuppiers();
        Set<String> names = suppilers.keySet();
        for (String name : names) {
            T obj = suppilers.get(name).get();
            Registry.register(registry,
                                ResourceLocation.fromNamespaceAndPath(helper.namespace(), name),
                                obj
                            );
            helper.getSuppiers().put(name, () -> obj);
        }
    }

    public static void registerSound() {
        Map<String, Supplier<Holder<SoundEvent>>> suppliers = Gears.EQUIP_COPPER_SOUND.getSuppiers();
        for (Map.Entry<String, Supplier<Holder<SoundEvent>>> entry : suppliers.entrySet()) {
            String name = entry.getKey();
            Holder<SoundEvent> holder = Registry.registerForHolder(
                BuiltInRegistries.SOUND_EVENT,
                ResourceLocation.fromNamespaceAndPath(Gears.EQUIP_COPPER_SOUND.namespace(), name),
                entry.getValue().get().value()
            );
            Gears.EQUIP_COPPER_SOUND.getSuppiers().put(name, () -> holder);
        }
    }
}
