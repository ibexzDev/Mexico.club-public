package me.earth.phobos.features.modules.combat;

import me.earth.phobos.features.modules.Module;
import me.earth.phobos.features.setting.Setting;

public class AutoKit extends Module {

    public Setting<String> kitname = this.register(new Setting<String>("Imperial", "Imperial"));

    public AutoKit() {
        super("AutoKit", "Claims kit", Category.Mexico, false, false, false);
    }

    @Override
    public void onEnable(){
        mc.player.sendChatMessage("/kit " + kitname);
        this.disable();
    }
}
