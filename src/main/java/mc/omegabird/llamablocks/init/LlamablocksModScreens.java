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
public class LlamablocksModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(LlamablocksModMenus.BACKPACKGUI.get(), BackpackguiScreen::new);
		event.register(LlamablocksModMenus.NETHERBACKPACKGUI.get(), NetherbackpackguiScreen::new);
		event.register(LlamablocksModMenus.COMPUTERGUI.get(), ComputerguiScreen::new);
		event.register(LlamablocksModMenus.SECURESTOORAGEPASSWORDGUI.get(), SecurestooragepasswordguiScreen::new);
		event.register(LlamablocksModMenus.AUTHBLOCKAUTHGUI.get(), AuthblockauthguiScreen::new);
		event.register(LlamablocksModMenus.COMPUTERAUTHGUI.get(), ComputerauthguiScreen::new);
		event.register(LlamablocksModMenus.PASSWORDCHANGERGUI.get(), PasswordchangerguiScreen::new);
		event.register(LlamablocksModMenus.INCORRECT_PASSWORD_GUI.get(), IncorrectPasswordGUIScreen::new);
		event.register(LlamablocksModMenus.DOUBLE_SECURE_STOORAFE_BLOCK_GUI.get(), DoubleSecureStoorafeBlockGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}