package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.entity.Entity;

import mc.omegabird.llamablocks.configuration.LlamamodserverconfigConfiguration;

public class PasswordResetPasswordChangerGUIPermissionProcedureProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.hasPermissions((int) (double) LlamamodserverconfigConfiguration.PASSWORD_CONTROL_PASSWORDS_PERMISSION_LEVEL.get());
	}
}