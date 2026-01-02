package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.ProblemReporter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import net.ihavenowebsite.omegabird.llamamod.LlamamodMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ForceResetPasswordViaLlamamodCommandProcedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		BlockState oldBlock = Blocks.AIR.defaultBlockState();
		if (entity instanceof Player _playerCmd0 && _playerCmd0.hasPermissions(4)) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(commandParameterBlockPos(arguments, "location").getX(), commandParameterBlockPos(arguments, "location").getY(), commandParameterBlockPos(arguments, "location").getZ());
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString("access_password", "");
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			oldBlock = (world.getBlockState(new BlockPos(commandParameterBlockPos(arguments, "location").getX(), commandParameterBlockPos(arguments, "location").getY() + 1, commandParameterBlockPos(arguments, "location").getZ())));
			{
				BlockPos _bp = new BlockPos(commandParameterBlockPos(arguments, "location").getX(), commandParameterBlockPos(arguments, "location").getY() + 1, commandParameterBlockPos(arguments, "location").getZ());
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
			LlamamodMod.queueServerWork(1, () -> {
			});
			{
				BlockPos _bp = new BlockPos(commandParameterBlockPos(arguments, "location").getX(), commandParameterBlockPos(arguments, "location").getY() + 1, commandParameterBlockPos(arguments, "location").getZ());
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
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}

	private static BlockPos commandParameterBlockPos(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return BlockPosArgument.getLoadedBlockPos(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return new BlockPos(0, 0, 0);
		}
	}
}