package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class ComputerguiWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) && _menu0.getMenuState(1, "auto_calculate", false)) {
			ComputercalculateprocidureProcedure.execute(entity);
		}
	}
}