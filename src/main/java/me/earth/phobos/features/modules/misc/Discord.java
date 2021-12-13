package me.earth.phobos.features.modules.misc;

import me.earth.phobos.features.modules.Module;

public class Discord extends Module {
    public Discord() {
        super("Discord", "https://discord.gg/vRuup3cetF", Category.Mexico, false, false, false);
    }

    @Override
    public void onEnable(){
        mc.player.sendChatMessage("https://discord.gg/vRuup3cetF on top!");
        this.disable();
    }
}
