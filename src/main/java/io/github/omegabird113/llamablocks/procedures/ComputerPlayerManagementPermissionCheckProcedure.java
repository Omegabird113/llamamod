package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.Entity;

public class ComputerPlayerManagementPermissionCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.hasPermissions(3)) {
			return true;
		}
		return false;
	}
}