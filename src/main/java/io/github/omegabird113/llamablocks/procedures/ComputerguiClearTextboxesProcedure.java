package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class ComputerguiClearTextboxesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "msg", "", true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "player_name", "", true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "number1", "", true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "number2", "", true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "operation", "", true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "calculator_result", "", true);
	}
}