package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class AuthblockupdateprocedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world instanceof Level _level0 ? _level0.getDefaultClockTime() : 0) - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "end_power_after_tick") > 15) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("powered") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		} else {
			LlamamodMod.LOGGER.debug(("Authenticator at (" + x + ", " + y + ", " + z + ") is powered as of tick: " + (world instanceof Level _level3 ? _level3.getDefaultClockTime() : 0)));
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}