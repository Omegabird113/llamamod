package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import mc.omegabird.llamablocks.init.LlamamodModBlocks;

public class BannanaplantOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double y_offest = 0;
		double totalheight = 0;
		totalheight = CountBananaPlantHeightProcedureProcedure.execute(world, x, y, z);
		y_offest = 1;
		while ((world.getBlockState(BlockPos.containing(x, y + y_offest, z))).getBlock() == LlamamodModBlocks.BANANA_PLANT.get()) {
			y_offest = y_offest + 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y + y_offest, z))).getBlock() == Blocks.AIR) {
			world.setBlock(BlockPos.containing(x, y + y_offest, z), LlamamodModBlocks.BANANA_PLANT.get().defaultBlockState(), 3);
			if ((world.getBlockState(BlockPos.containing(x, y + y_offest + 1, z))).getBlock() == Blocks.AIR && totalheight != 4) {
				world.setBlock(BlockPos.containing(x, y + y_offest + 1, z), LlamamodModBlocks.BANANA_PLANT.get().defaultBlockState(), 3);
			}
		}
	}
}