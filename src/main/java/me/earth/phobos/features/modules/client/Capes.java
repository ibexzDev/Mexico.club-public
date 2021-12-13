package me.earth.phobos.features.modules.client;

import me.earth.phobos.features.modules.Module;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class Capes
        extends Module {
    public static final ResourceLocation THREEVT_CAPE = new ResourceLocation("textures/3vt2.png");
    public static final ResourceLocation ZBOB_CAPE = new ResourceLocation("textures/zb0b.png");
    public static final ResourceLocation OHARE_CAPE = new ResourceLocation("textures/ohare.png");
    public static final ResourceLocation SQUID_CAPE = new ResourceLocation("textures/squidcape.png");
    public static Map<String, String[]> UUIDs = new HashMap<String, String[]>();
    private static Capes instance;

    public Capes() {
        super("Capes", "Renders the client's capes", Module.Category.CLIENT, false, false, false);
        UUIDs.put("Megyn", new String[]{"a5e36d37-5fbe-4481-b5be-1f06baee1f1c", "7de842e8-af08-49ed-9d0c-4071e2a99f00", "8ca55379-c872-4299-987d-d20962badd11", "e6e8bf7e-0b23-4d2e-b2ae-c40c5ff4eecc"});
        UUIDs.put("zb0b", new String[]{"0aa3b04f-786a-49c8-bea9-025ee0dd1e85"});
        UUIDs.put("BetaCalculatorMC", new String[]{"BetaCalculatorMC"});
        UUIDs.put("AlphaArmor", new String[]{"0de5649a-0086-4b46-861e-675630e1db7e"});
        UUIDs.put("Squid", new String[]{"811c9272-9793-4fdd-980d-778e8ad2e54c", "09410a87-dfc8-476c-9acb-04bd07126c6e", "2eb88d28-7a26-43ad-81aa-113bd818d977"});
        instance = this;
    }

    public static Capes getInstance() {
        if (instance == null) {
            instance = new Capes();
        }
        return instance;
    }

    public static ResourceLocation getCapeResource(AbstractClientPlayer player) {
        for (String name : UUIDs.keySet()) {
            for (String uuid : UUIDs.get(name)) {
                if (name.equalsIgnoreCase("BetaCalculatorMC") && player.getUniqueID().toString().equals(uuid)) {
                    return THREEVT_CAPE;
                }
                if (name.equalsIgnoreCase("Megyn") && player.getUniqueID().toString().equals(uuid)) {
                    return THREEVT_CAPE;
                }
                if (!name.equalsIgnoreCase("oHare") || !player.getUniqueID().toString().equals(uuid)) continue;
                return OHARE_CAPE;
            }
        }
        return null;
    }

    public static boolean hasCape(UUID uuid) {
        Iterator<String> iterator = UUIDs.keySet().iterator();
        if (iterator.hasNext()) {
            String name = iterator.next();
            return Arrays.asList((Object[]) UUIDs.get(name)).contains(uuid.toString());
        }
        return false;
    }
}

