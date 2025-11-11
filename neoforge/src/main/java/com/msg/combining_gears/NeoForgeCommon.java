package com.msg.combining_gears;

import com.msg.combining_gears.items.Gears;
import com.msg.combining_gears.platform.FoxRegister;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.NAMESPACE)
public class NeoForgeCommon {

    public NeoForgeCommon(IEventBus eventBus) {

        Common.init();
        FoxRegister.registry(eventBus, FoxRegister.ITEMS, Gears.ITEMS);
        FoxRegister.registry(eventBus, FoxRegister.BACKPORT_GEARS, Gears.BACKPORT_GEARS);
        FoxRegister.SOUND_EVENTS.register(eventBus);

    }
}