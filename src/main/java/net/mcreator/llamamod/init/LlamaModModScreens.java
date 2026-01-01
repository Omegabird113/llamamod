/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.llamamod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.llamamod.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
public class LlamaModModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(LlamaModModMenus.BACKPACKGUI.get(), BackpackguiScreen::new);
		event.register(LlamaModModMenus.NETHERBACKPACKGUI.get(), NetherbackpackguiScreen::new);
		event.register(LlamaModModMenus.COMPUTERGUI.get(), ComputerguiScreen::new);
		event.register(LlamaModModMenus.SECURESTOORAGEPASSWORDGUI.get(), SecurestooragepasswordguiScreen::new);
		event.register(LlamaModModMenus.AUTHBLOCKAUTHGUI.get(), AuthblockauthguiScreen::new);
		event.register(LlamaModModMenus.COMPUTERAUTHGUI.get(), ComputerauthguiScreen::new);
		event.register(LlamaModModMenus.PASSWORDCHANGERGUI.get(), PasswordchangerguiScreen::new);
		event.register(LlamaModModMenus.INCORRECT_PASSWORD_GUI.get(), IncorrectPasswordGUIScreen::new);
		event.register(LlamaModModMenus.DOUBLE_SECURE_STOORAFE_BLOCK_GUI.get(), DoubleSecureStoorafeBlockGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}