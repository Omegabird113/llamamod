package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import mc.omegabird.llamablocks.configuration.LlamamodserverconfigConfiguration;

public class ComputerPlayerManagementPermissionCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player _playerCmd1 && _playerCmd1.hasPermissions((int) (double) LlamamodserverconfigConfiguration.COMPUTER_PLAYER_MANAGEMENT_PERMISSION_LEVEL.get())) {
			return true;
		}
		return false;
	}
}