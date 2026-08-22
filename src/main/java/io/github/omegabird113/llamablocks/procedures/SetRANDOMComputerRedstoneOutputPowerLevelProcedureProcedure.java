package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class SetRANDOMComputerRedstoneOutputPowerLevelProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double val = 0;
		val = Mth.nextDouble(RandomSource.create(), 0, 15);
		{
			int _value = (int) val;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("power") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 2, "power_output", val, true);
	}
}