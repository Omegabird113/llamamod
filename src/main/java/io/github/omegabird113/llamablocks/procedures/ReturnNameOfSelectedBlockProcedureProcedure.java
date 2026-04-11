package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class ReturnNameOfSelectedBlockProcedureProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return "" + (((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).getDisplayName().getString()).replace("]", "")).replace("[", "");
	}
}