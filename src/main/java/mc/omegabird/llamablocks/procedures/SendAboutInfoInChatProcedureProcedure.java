package mc.omegabird.llamablocks.procedures;

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
			_player.displayClientMessage(Component.literal(
					("About LlamaBlocks -- version " + "1.2.0beta1" + " made for Minecraft 1.21.8 w/ Neoforge " + "-- LlamaMod is developed by Omegabird113 w/ MCreator version " + "2025.3, plus the Blockstates and Configuration Files plugins.")),
					false);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						"tellraw @s [\"Download it or see more info from: \",{\"text\":\"https://modrinth.com/mod/llamablocks\",\"underlined\":true,\"color\":\"green\",\"click_event\":{\"action\":\"open_url\",\"url\":\"https://modrinth.com/mod/llamablocks\"}},\".\"]");
			}
		}
		if (IsThisBetaProcedureProcedure.execute() == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("WARNING: This is a BETA version of LlamaMod. Please report any issues or suggestions as Issues on GitHub."), false);
		}
	}
}