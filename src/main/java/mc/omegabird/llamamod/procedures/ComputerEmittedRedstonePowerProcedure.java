package mc.omegabird.llamamod.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;

public class ComputerEmittedRedstonePowerProcedure {
	public static double execute(BlockState blockstate) {
		return blockstate.getBlock().getStateDefinition().getProperty("power") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1;
	}
}