package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModMenus;

import java.util.ArrayList;

public class CompsendmsgprocidureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity player_to_msg = null;
		String msg_to_send = "";
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "player_name", "") : "")) {
				msg_to_send = (entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "msg", "") : "";
				player_to_msg = entityiterator;
			}
		}
		if (player_to_msg == null) {
			msg_to_send = "ERROR: Invalid player name. (Please note the player name input feild is case sensitive)";
			player_to_msg = entity;
		}
		if (player_to_msg instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(msg_to_send), false);
	}
}