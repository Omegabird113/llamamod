package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModMenus;

public class IsAllowClearingBoxCheckedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) && _menu0.getMenuState(1, "allow_clearing", false);
	}
}