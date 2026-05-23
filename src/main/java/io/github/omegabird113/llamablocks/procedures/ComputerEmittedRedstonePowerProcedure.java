package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;

public class ComputerEmittedRedstonePowerProcedure {
	public static double execute(BlockState blockstate) {
		return getPropertyByName(blockstate, "power") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}