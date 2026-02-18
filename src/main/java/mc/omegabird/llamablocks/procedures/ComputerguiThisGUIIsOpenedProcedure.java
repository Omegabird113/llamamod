package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.ProblemReporter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import mc.omegabird.llamablocks.init.LlamamodModMenus;

public class ComputerguiThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState oldBlock = Blocks.AIR.defaultBlockState();
		oldBlock = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
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
		{
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockState _bs = Blocks.REINFORCED_DEEPSLATE.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata(world.registryAccess());
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockState _bs = oldBlock;
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata(world.registryAccess());
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, world.registryAccess(), _bnbt));
					} catch (Exception ignored) {
					}
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}