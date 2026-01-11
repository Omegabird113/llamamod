/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import mc.omegabird.llamamod.world.inventory.*;
import mc.omegabird.llamamod.network.MenuStateUpdateMessage;
import mc.omegabird.llamamod.LlamamodMod;

import java.util.Map;

public class LlamamodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, LlamamodMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackguiMenu>> BACKPACKGUI = REGISTRY.register("backpackgui", () -> IMenuTypeExtension.create(BackpackguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NetherbackpackguiMenu>> NETHERBACKPACKGUI = REGISTRY.register("netherbackpackgui", () -> IMenuTypeExtension.create(NetherbackpackguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ComputerguiMenu>> COMPUTERGUI = REGISTRY.register("computergui", () -> IMenuTypeExtension.create(ComputerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SecurestooragepasswordguiMenu>> SECURESTOORAGEPASSWORDGUI = REGISTRY.register("securestooragepasswordgui", () -> IMenuTypeExtension.create(SecurestooragepasswordguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AuthblockauthguiMenu>> AUTHBLOCKAUTHGUI = REGISTRY.register("authblockauthgui", () -> IMenuTypeExtension.create(AuthblockauthguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ComputerauthguiMenu>> COMPUTERAUTHGUI = REGISTRY.register("computerauthgui", () -> IMenuTypeExtension.create(ComputerauthguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PasswordchangerguiMenu>> PASSWORDCHANGERGUI = REGISTRY.register("passwordchangergui", () -> IMenuTypeExtension.create(PasswordchangerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IncorrectPasswordGUIMenu>> INCORRECT_PASSWORD_GUI = REGISTRY.register("incorrect_password_gui", () -> IMenuTypeExtension.create(IncorrectPasswordGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DoubleSecureStoorafeBlockGuiMenu>> DOUBLE_SECURE_STOORAFE_BLOCK_GUI = REGISTRY.register("double_secure_stoorafe_block_gui",
			() -> IMenuTypeExtension.create(DoubleSecureStoorafeBlockGuiMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof LlamamodModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				ClientPacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}