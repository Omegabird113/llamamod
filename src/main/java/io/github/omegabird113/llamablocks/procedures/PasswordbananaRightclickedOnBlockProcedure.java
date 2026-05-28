package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class PasswordbananaRightclickedOnBlockProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof Player _plr0 && _plr0.gameMode() == GameType.CREATIVE && hasEntityPermissionLevel(entity, 3)) {
			return getBlockNBTString(world, BlockPos.containing(x, y, z), "access_password");
		} else {
			LlamamodMod.LOGGER.debug(("Player DOES NOT have permission to see password. DId not return password." + entity));
		}
		return "ERROR: Access Denied";
	}

	private static boolean hasEntityPermissionLevel(Entity entity, int permissionLevel) {
		if (entity instanceof Player _player) {
			return switch (permissionLevel) {
				case 0 -> true;
				case 1 -> _player.permissions().hasPermission(Permissions.COMMANDS_MODERATOR);
				case 2 -> _player.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER);
				case 3 -> _player.permissions().hasPermission(Permissions.COMMANDS_ADMIN);
				default -> _player.permissions().hasPermission(Permissions.COMMANDS_OWNER);
			};
		}
		return false;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}