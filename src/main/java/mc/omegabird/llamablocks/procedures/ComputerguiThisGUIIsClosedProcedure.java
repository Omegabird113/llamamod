package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import mc.omegabird.llamablocks.init.LlamamodModMenus;

public class ComputerguiThisGUIIsClosedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putString("msg", ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "msg", "") : ""));
				_blockEntity.getPersistentData().putString("player_name", ((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "player_name", "") : ""));
				_blockEntity.getPersistentData().putString("number1", ((entity instanceof Player _entity4 && _entity4.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "number1", "") : ""));
				_blockEntity.getPersistentData().putString("number2", ((entity instanceof Player _entity6 && _entity6.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(0, "number2", "") : ""));
				_blockEntity.getPersistentData().putString("operation", ((entity instanceof Player _entity8 && _entity8.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(0, "operation", "") : ""));
				_blockEntity.getPersistentData().putString("calculator_result",
						((entity instanceof Player _entity10 && _entity10.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(0, "calculator_result", "") : ""));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}