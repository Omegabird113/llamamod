package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModBlocks;

public class CanBoneMealBeUsedOnBananaPlantProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double y_offset = 0;
		y_offset = 0;
		if (CountBananaPlantHeightProcedureProcedure.execute(world, x, y, z) < 5) {
			while ((world.getBlockState(BlockPos.containing(x, y + y_offset, z))).getBlock() == LlamamodModBlocks.BANANA_PLANT.get()) {
				y_offset = y_offset + 1;
			}
			if ((world.getBlockState(BlockPos.containing(x, y + y_offset, z))).getBlock() == Blocks.AIR) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}