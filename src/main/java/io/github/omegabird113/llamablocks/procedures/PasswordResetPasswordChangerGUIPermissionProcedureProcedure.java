package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class PasswordResetPasswordChangerGUIPermissionProcedureProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof Player _playerCmd0 && _playerCmd0.hasPermissions(3);
	}
}