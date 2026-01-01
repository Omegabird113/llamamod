package net.mcreator.llamamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.llamamod.init.LlamaModModBlocks;

public class BannanaplantOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double y_offest = 0;
		double totalheight = 0;
		totalheight = CountBananaPlantHeightProcedureProcedure.execute(world, x, y, z);
		y_offest = 1;
		while ((world.getBlockState(BlockPos.containing(x, y + y_offest, z))).getBlock() == LlamaModModBlocks.BANANA_PLANT.get()) {
			y_offest = y_offest + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y + y_offest, z))).getBlock() == Blocks.AIR) {
			world.setBlock(BlockPos.containing(x, y + y_offest, z), LlamaModModBlocks.BANANA_PLANT.get().defaultBlockState(), 3);
			if ((world.getBlockState(BlockPos.containing(x, y + y_offest + 1, z))).getBlock() == Blocks.AIR && totalheight != 4) {
				world.setBlock(BlockPos.containing(x, y + y_offest + 1, z), LlamaModModBlocks.BANANA_PLANT.get().defaultBlockState(), 3);
			}
		}
	}
}