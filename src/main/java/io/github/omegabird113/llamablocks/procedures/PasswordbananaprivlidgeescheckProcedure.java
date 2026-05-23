package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class PasswordbananaprivlidgeescheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player _plr0 && _plr0.gameMode() == GameType.CREATIVE && entity instanceof Player _playerCmd1 && _playerCmd1.hasPermissions(3)) {
			return true;
		}
		return false;
	}
}