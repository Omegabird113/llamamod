package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ComputerPlayerManagementPermissionCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player _playerCmd0 && _playerCmd0.hasPermissions(3)) {
			return true;
		}
		return false;
	}
}