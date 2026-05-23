package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

public class PrinttimetochatProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(GettimeasstringProcedure.execute(world)).withStyle(_s -> _s.withColor(0x00c800)), false);
		}
	}
}