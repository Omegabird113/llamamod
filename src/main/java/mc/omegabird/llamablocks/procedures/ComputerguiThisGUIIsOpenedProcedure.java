package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import mc.omegabird.llamablocks.init.LlamamodModMenus;

public class ComputerguiThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "msg", (getBlockNBTString(world, BlockPos.containing(x, y, z), "msg")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "player_name", (getBlockNBTString(world, BlockPos.containing(x, y, z), "player_name")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "number1", (getBlockNBTString(world, BlockPos.containing(x, y, z), "number1")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "number2", (getBlockNBTString(world, BlockPos.containing(x, y, z), "number2")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "operation", (getBlockNBTString(world, BlockPos.containing(x, y, z), "operation")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "calculator_result", (getBlockNBTString(world, BlockPos.containing(x, y, z), "calculator_result")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 2, "power_output", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power_output")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 1, "auto_calculate", (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "auto_calculate")), true);
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}