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

import java.util.Map;

public class PasswordchangerresetpasswordprocedureProcedure {
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
				_blockEntity.getPersistentData().putString("access_password", "");
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 1, z);
			BlockState _bs = Blocks.REINFORCED_DEEPSLATE.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata();
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.load(_bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 1, z);
			BlockState _bs = oldBlock;
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata();
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.load(_bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}