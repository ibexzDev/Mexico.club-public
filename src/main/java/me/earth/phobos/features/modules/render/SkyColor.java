package me.earth.phobos.features.modules.render;

import me.earth.phobos.features.modules.*;
import me.earth.phobos.features.setting.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.common.*;

public class SkyColor extends Module
{
    private final Setting<Integer> red;
    private final Setting<Integer> green;
    private final Setting<Integer> blue;

    public SkyColor() {
        super("SkyColor",  "Change the sky color.",  Module.Category.RENDER,  false,  false,  false);
        this.red = (Setting<Integer>)this.register(new Setting("Red", 255, 0, 255));
        this.green = (Setting<Integer>)this.register(new Setting("Green", 255, 0, 255));
        this.blue = (Setting<Integer>)this.register(new Setting("Blue", 255, 0, 255));
    }

    @SubscribeEvent
    public void onUpdate(final EntityViewRenderEvent.FogColors event) {
        event.setRed(this.red.getValue() / 255.0f);
        event.setGreen(this.green.getValue() / 255.0f);
        event.setBlue(this.blue.getValue() / 255.0f);
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
}