package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class SendAboutInfoInChatProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(Component.literal(("About LlamaBlocks --" + "\n" + "Version " + ReturnLlamaModVersionProcedureProcedure.execute() + " made for Minecraft " + ReturnMinecraftVersionProcedureProcedure.execute() + " w/ Neoforge."
					+ "\n" + "\n" + "LlamaMod is developed by Omegabird113 w/ MCreator version " + "2026.2.33218." + "\n")), false);
		if ((ReturnMinecraftVersionProcedureProcedure.execute()).equals("26.1.2")) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							"tellraw @s [\"Download it or see more info from: \",{\"text\":\"https://modrinth.com/mod/llamablocks\",\"underlined\":true,\"color\":\"green\",\"click_event\":{\"action\":\"open_url\",\"url\":\"https://modrinth.com/mod/llamablocks\"}},\".\"]");
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					_ent.level().getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, LevelBasedPermissionSet.OWNER, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
							"tellraw @s [\"Download it or see more info from: \",{\"text\":\"https://modrinth.com/mod/llamablocks\",\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://modrinth.com/mod/llamablocks\"}},\".\"]");
				}
			}
		}
		LlamamodMod.queueServerWork(1, () -> {
			if (IsThisBetaProcedureProcedure.execute() == true) {
				if (entity instanceof ServerPlayer _player)
					_player.sendSystemMessage(Component.literal((Component.translatable("llamamod.about.beta_warning_chat_message").getString())), false);
			}
		});
	}
}