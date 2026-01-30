package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import mc.omegabird.llamablocks.configuration.LlamamodserverconfigConfiguration;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GetpasswordcmdgetpasswordinchatprocedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerCmd1 && _playerCmd1.hasPermissions((int) (double) LlamamodserverconfigConfiguration.ACCESS_EXISTING_PASSWORDS_PERMISSION_LEVEL.get())) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((getBlockNBTString(world,
						new BlockPos(commandParameterBlockPos(arguments, "location").getX(), commandParameterBlockPos(arguments, "location").getY(), commandParameterBlockPos(arguments, "location").getZ()), "access_password"))), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("ERROR: Access Denied"), false);
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

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}