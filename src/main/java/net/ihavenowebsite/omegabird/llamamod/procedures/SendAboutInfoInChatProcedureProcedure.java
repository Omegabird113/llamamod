package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SendAboutInfoInChatProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("About LLamaMod -- version " + "0.46dev, " + "made for Minecraft 1.21.8 w/ Neoforge " + "-- LlamaMod is developed by Omegabird113 w/ MCreator version " + "2025.3, plus the Blockstates plugin.")), false);
	}
}