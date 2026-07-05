package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class CompsendmsgprocidureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity player_to_msg = null;
		String msg_to_send = "";
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (((entityiterator.getDisplayName().getString()).toUpperCase())
					.equals((((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "player_name", "") : "").toUpperCase()).strip())) {
				msg_to_send = (entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "msg", "") : "";
				player_to_msg = entityiterator;
			}
		}
		if (player_to_msg == null) {
			msg_to_send = Component.translatable("block.llamamod.computer.playernamenotfounderror").getString();
			player_to_msg = entity;
		}
		LlamamodMod.LOGGER.debug(("The following player has a message attempting to be sent to them: " + player_to_msg));
		if (player_to_msg instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal(msg_to_send), false);
	}
}