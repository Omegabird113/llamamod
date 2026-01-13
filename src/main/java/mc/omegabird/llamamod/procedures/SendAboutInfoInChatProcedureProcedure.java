package mc.omegabird.llamamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SendAboutInfoInChatProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("About LLamaMod -- version " + "1.0.0-beta5" + " made for Minecraft 1.21.8 w/ Neoforge " + "-- LlamaMod is developed by Omegabird113 w/ MCreator version " + "2025.3, plus the Blockstates plugin.")), false);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						"tellraw @s  [\"\",{\"text\":\"To view LlamaMod's source code, visit:\"},{\"text\":\" \",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/Omegabird113/llamamod/\"}},{\"text\":\"https://github.com/Omegabird113/llamamod/\",\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/Omegabird113/llamamod/\"}}]");
			}
		}
	}
}