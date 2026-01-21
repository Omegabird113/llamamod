package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import mc.omegabird.llamablocks.init.LlamamodModMenus;

import java.util.ArrayList;

public class CompClearInventoryOfPlayerXProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity player_to_msg = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "player_name", "") : "")) {
				player_to_msg = entityiterator;
			}
		}
		if (player_to_msg == null) {
			player_to_msg = entity;
			if (player_to_msg instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("ERROR: Invalid player name. (Please note the player name input feild is case sensitive)"), false);
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/clear " + player_to_msg.getDisplayName().getString()));
				}
			}
		}
	}
}