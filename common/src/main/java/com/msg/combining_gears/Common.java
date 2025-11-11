package com.msg.combining_gears;

import com.msg.combining_gears.platform.Services;

import net.minecraft.resources.ResourceLocation;

public class Common {

    public static void init() {

        Constants.LOG.info("Mod {} is running on {}! we are currently in a {} environment!", 
                            Constants.MOD_NAME,
                            Services.PLATFORM.getPlatformName(),
                            Services.PLATFORM.getEnvironmentName());
    }

    public static ResourceLocation resourcesLocation(String path){
        return ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, path);
    }
}