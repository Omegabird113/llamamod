package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class GenRandomNumberForLmCommandProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (BoolArgumentType.getBool(arguments, "wholeNumber")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + Mth.nextInt(RandomSource.create(), (int) DoubleArgumentType.getDouble(arguments, "minimum"), (int) DoubleArgumentType.getDouble(arguments, "maximum")))), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "minimum"), DoubleArgumentType.getDouble(arguments, "maximum")))), false);
		}
	}
}