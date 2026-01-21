package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;

public class IspoweredProcedure {
	public static double execute(BlockState blockstate) {
		if (blockstate.getBlock().getStateDefinition().getProperty("powered") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			return 15;
		}
		return 0;
	}
}