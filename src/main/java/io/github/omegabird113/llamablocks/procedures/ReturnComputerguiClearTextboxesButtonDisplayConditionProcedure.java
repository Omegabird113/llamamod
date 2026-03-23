package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class ReturnComputerguiClearTextboxesButtonDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "msg", "") : "").isEmpty()) {
			return true;
		}
		if (!((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "player_name", "") : "").isEmpty()) {
			return true;
		}
		if (!((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "number1", "") : "").isEmpty()) {
			return true;
		}
		if (!((entity instanceof Player _entity3 && _entity3.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "number2", "") : "").isEmpty()) {
			return true;
		}
		if (!((entity instanceof Player _entity4 && _entity4.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "operation", "") : "").isEmpty()) {
			return true;
		}
		if (!((entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "calculator_result", "") : "").isEmpty()) {
			return true;
		}
		return false;
	}
}