package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class CompmsgnotblankProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "msg")).equals("")) {
			LlamamodMod.LOGGER.debug(("There is a message saved in Computer at (" + x + ", " + y + ", " + z + "). The Load button is displayed as of tick: " + world.getGameTime()));
			return true;
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