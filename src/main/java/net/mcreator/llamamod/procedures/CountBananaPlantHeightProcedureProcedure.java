package net.mcreator.llamamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.llamamod.init.LlamaModModBlocks;

public class CountBananaPlantHeightProcedureProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double blocks_below = 0;
		double blocks_above = 0;
		blocks_below = 0;
		blocks_above = 0;
		while (true) {
			if ((world.getBlockState(BlockPos.containing(x, y - (1 + blocks_below), z))).getBlock() == LlamaModModBlocks.BANANA_PLANT.get()) {
				blocks_below = blocks_below + 1;
			} else {
				break;
			}
		}
		while (true) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1 + blocks_above, z))).getBlock() == LlamaModModBlocks.BANANA_PLANT.get()) {
				blocks_above = blocks_above + 1;
			} else {
				break;
			}
		}
		return blocks_above + 1 + blocks_below;
	}
}