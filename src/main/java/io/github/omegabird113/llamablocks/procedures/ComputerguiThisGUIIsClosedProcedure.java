package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class ComputerguiThisGUIIsClosedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState oldBlock = Blocks.AIR.defaultBlockState();
		oldBlock = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putString("msg", ((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "msg", "") : ""));
				_blockEntity.getPersistentData().putString("player_name", ((entity instanceof Player _entity3 && _entity3.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "player_name", "") : ""));
				_blockEntity.getPersistentData().putString("number1", ((entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "number1", "") : ""));
				_blockEntity.getPersistentData().putString("number2", ((entity instanceof Player _entity7 && _entity7.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(0, "number2", "") : ""));
				_blockEntity.getPersistentData().putString("operation", ((entity instanceof Player _entity9 && _entity9.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "operation", "") : ""));
				_blockEntity.getPersistentData().putString("calculator_result",
						((entity instanceof Player _entity11 && _entity11.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu11) ? _menu11.getMenuState(0, "calculator_result", "") : ""));
				_blockEntity.getPersistentData().putDouble("power_output", ((entity instanceof Player _entity13 && _entity13.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu13) ? _menu13.getMenuState(2, "power_output", 0.0) : 0.0));
				_blockEntity.getPersistentData().putBoolean("auto_calculate", ((entity instanceof Player _entity15 && _entity15.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu15) && _menu15.getMenuState(1, "auto_calculate", false)));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 1, z);
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
						_be.loadWithComponents(_bnbt, world.registryAccess());
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 1, z);
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
						_be.loadWithComponents(_bnbt, world.registryAccess());
					} catch (Exception ignored) {
					}
				}
			}
		}
	}
}