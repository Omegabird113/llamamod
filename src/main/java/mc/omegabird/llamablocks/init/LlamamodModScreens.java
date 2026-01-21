/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamablocks.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import mc.omegabird.llamablocks.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
public class LlamamodModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(LlamamodModMenus.BACKPACKGUI.get(), BackpackguiScreen::new);
		event.register(LlamamodModMenus.NETHERBACKPACKGUI.get(), NetherbackpackguiScreen::new);
		event.register(LlamamodModMenus.COMPUTERGUI.get(), ComputerguiScreen::new);
		event.register(LlamamodModMenus.SECURESTOORAGEPASSWORDGUI.get(), SecurestooragepasswordguiScreen::new);
		event.register(LlamamodModMenus.AUTHBLOCKAUTHGUI.get(), AuthblockauthguiScreen::new);
		event.register(LlamamodModMenus.COMPUTERAUTHGUI.get(), ComputerauthguiScreen::new);
		event.register(LlamamodModMenus.PASSWORDCHANGERGUI.get(), PasswordchangerguiScreen::new);
		event.register(LlamamodModMenus.INCORRECT_PASSWORD_GUI.get(), IncorrectPasswordGUIScreen::new);
		event.register(LlamamodModMenus.DOUBLE_SECURE_STOORAFE_BLOCK_GUI.get(), DoubleSecureStoorafeBlockGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}