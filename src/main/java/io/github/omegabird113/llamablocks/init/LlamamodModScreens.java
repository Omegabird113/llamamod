/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import io.github.omegabird113.llamablocks.client.gui.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LlamamodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(LlamamodModMenus.BACKPACKGUI.get(), BackpackguiScreen::new);
			MenuScreens.register(LlamamodModMenus.NETHERBACKPACKGUI.get(), NetherbackpackguiScreen::new);
			MenuScreens.register(LlamamodModMenus.COMPUTERGUI.get(), ComputerguiScreen::new);
			MenuScreens.register(LlamamodModMenus.PASSWORDCHANGERGUI.get(), PasswordchangerguiScreen::new);
			MenuScreens.register(LlamamodModMenus.INCORRECT_PASSWORD_GUI.get(), IncorrectPasswordGUIScreen::new);
			MenuScreens.register(LlamamodModMenus.DOUBLE_SECURE_STOORAFE_BLOCK_GUI.get(), DoubleSecureStoorafeBlockGuiScreen::new);
			MenuScreens.register(LlamamodModMenus.PASSWORDS_NOT_SUPPORTED_GUI.get(), PasswordsNotSupportedGUIScreen::new);
			MenuScreens.register(LlamamodModMenus.AUTH_GUI.get(), AuthGUIScreen::new);
		});
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}