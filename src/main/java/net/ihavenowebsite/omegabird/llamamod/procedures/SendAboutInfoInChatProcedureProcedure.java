package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SendAboutInfoInChatProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("About LLamaMod -- version " + "1.0.0-beta5" + " made for Minecraft 1.21.8 w/ Neoforge " + "-- LlamaMod is developed by Omegabird113 w/ MCreator version " + "2025.3, plus the Blockstates plugin.")), false);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
					+ entity.getDisplayName().getString()
					+ " [\"\",{\"text\":\"To view LlamaMod's source code, visit:\"},{\"text\":\" \",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/Omegabird113/llamamod/\"}},{\"text\":\"https://github.com/Omegabird113/llamamod/\",\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/Omegabird113/llamamod/\"}}]"));
	}
}