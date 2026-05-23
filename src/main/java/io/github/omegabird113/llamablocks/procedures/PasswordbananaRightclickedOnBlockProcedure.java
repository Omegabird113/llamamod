package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class PasswordbananaRightclickedOnBlockProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof Player _plr0 && _plr0.gameMode() == GameType.CREATIVE && entity instanceof Player _playerCmd1 && _playerCmd1.hasPermissions(3)) {
			return getBlockNBTString(world, BlockPos.containing(x, y, z), "access_password");
		} else {
			LlamamodMod.LOGGER.debug(("Player DOES NOT have permission to see password. DId not return password." + entity));
		}
		return "ERROR: Access Denied";
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}