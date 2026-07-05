package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class SendMinecraftVersionInChatProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal(ReturnMinecraftVersionProcedureProcedure.execute()), false);
	}
}