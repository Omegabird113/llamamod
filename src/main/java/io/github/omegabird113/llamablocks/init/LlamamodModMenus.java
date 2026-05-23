/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import java.util.Map;

import io.github.omegabird113.llamablocks.world.inventory.*;
import io.github.omegabird113.llamablocks.network.MenuStateUpdateMessage;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LlamamodMod.MODID);
	public static final RegistryObject<MenuType<BackpackguiMenu>> BACKPACKGUI = REGISTRY.register("backpackgui", () -> IForgeMenuType.create(BackpackguiMenu::new));
	public static final RegistryObject<MenuType<NetherbackpackguiMenu>> NETHERBACKPACKGUI = REGISTRY.register("netherbackpackgui", () -> IForgeMenuType.create(NetherbackpackguiMenu::new));
	public static final RegistryObject<MenuType<ComputerguiMenu>> COMPUTERGUI = REGISTRY.register("computergui", () -> IForgeMenuType.create(ComputerguiMenu::new));
	public static final RegistryObject<MenuType<PasswordchangerguiMenu>> PASSWORDCHANGERGUI = REGISTRY.register("passwordchangergui", () -> IForgeMenuType.create(PasswordchangerguiMenu::new));
	public static final RegistryObject<MenuType<IncorrectPasswordGUIMenu>> INCORRECT_PASSWORD_GUI = REGISTRY.register("incorrect_password_gui", () -> IForgeMenuType.create(IncorrectPasswordGUIMenu::new));
	public static final RegistryObject<MenuType<DoubleSecureStoorafeBlockGuiMenu>> DOUBLE_SECURE_STOORAFE_BLOCK_GUI = REGISTRY.register("double_secure_stoorafe_block_gui", () -> IForgeMenuType.create(DoubleSecureStoorafeBlockGuiMenu::new));
	public static final RegistryObject<MenuType<PasswordsNotSupportedGUIMenu>> PASSWORDS_NOT_SUPPORTED_GUI = REGISTRY.register("passwords_not_supported_gui", () -> IForgeMenuType.create(PasswordsNotSupportedGUIMenu::new));
	public static final RegistryObject<MenuType<AuthGUIMenu>> AUTH_GUI = REGISTRY.register("auth_gui", () -> IForgeMenuType.create(AuthGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				LlamamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof LlamamodModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				LlamamodMod.PACKET_HANDLER.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
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