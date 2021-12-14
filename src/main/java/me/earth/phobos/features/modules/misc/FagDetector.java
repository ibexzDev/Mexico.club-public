package me.earth.phobos.features.modules.misc;

import com.mojang.text2speech.Narrator;
import me.earth.phobos.event.events.DeathEvent;
import me.earth.phobos.event.events.TotemPopEvent;
import me.earth.phobos.features.modules.Module;
import me.earth.phobos.features.setting.Setting;

public class FagDetector extends Module {

    public Setting<String> totemPopMessage = this.register(new Setting<String>("PopMessage", "<player> Stop Poping retard! L"));
    public Setting<String> deathMessages = this.register(new Setting<String>("DeathMessage", "<player> you retard you just fucking died! Retard"));

    public FagDetector() {
        super("FagDetector", "Fag Detector in view range", Category.Mexico, true, false, false);
    }
    private final Narrator narrator = Narrator.getNarrator();
    @Override
    public void onEnable(){
        narrator.say("Welcome " + mc.player.getName() + "to Mexico.club botnet");
        narrator.clear();
    }

    @Override
    public void onDisable() {
        this.narrator.clear();
    }

    @SubscribeEvent
    public void onTotemPop(TotemPopEvent event) {
        if (event.getEntity() == Companion.mc.player) {
            this.narrator.say(this.totemPopMessage.getValue().replaceAll("<player>", Companion.mc.player.getName()));
        }
    }

    @SubscribeEvent
    public void onDeath(DeathEvent event) {
        if (event.player == Companion.mc.player) {
            this.narrator.say(this.deathMessages.getValue().replaceAll("<player>", Companion.mc.player.getName()));
        }
    }

}
