package org.teacon.signmeup.input;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;
import org.teacon.signmeup.gui.MapScreen;

/**
 * @author USS_Shenzhou
 */
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ModKeyInput {
    public static final KeyMapping OPEN_MAP = new KeyMapping(
            "key.sign_up.open_map", KeyConflictContext.IN_GAME, KeyModifier.NONE,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, "key.categories.sign_up"
    );    public static final KeyMapping OPEN_NEW_MAP = new KeyMapping(
            "key.sign_up.open_new_map", KeyConflictContext.IN_GAME, KeyModifier.ALT,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, "key.categories.sign_up"
    );


    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (OPEN_NEW_MAP.consumeClick()) {
            Minecraft.getInstance().setScreen(MapScreen.getNewInstance());
        }
        if (OPEN_MAP.consumeClick()) {
            Minecraft.getInstance().setScreen(MapScreen.getInstance());
        }
    }
}