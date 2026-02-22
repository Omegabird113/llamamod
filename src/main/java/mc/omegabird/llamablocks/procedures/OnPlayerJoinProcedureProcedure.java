package mc.omegabird.llamablocks.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import mc.omegabird.llamablocks.init.LlamamodModGameRules;
import mc.omegabird.llamablocks.LlamamodMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OnPlayerJoinProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		LlamamodMod.LOGGER.debug("LlamaBlocks Procedure \"onPlayerJoin\" executed, as a player has joined world.");
		if (world.getLevelData().getGameRules().getBoolean(LlamamodModGameRules.GIVE_ALL_RECIPES) == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"recipe give @a *");
			LlamamodMod.LOGGER.debug("All recipe given to all players.");
		}
		if (IsThisBetaProcedureProcedure.execute() == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("WARNING: This is a BETA version of LlamaMod. Please report any issues or suggestions as Issues on GitHub. (https://github.com/Omegabird113/llamamod)"), false);
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("You're running: " + ReturnLlamaModVersionProcedureProcedure.execute())).withColor(0xff00ff), false);
			}
			LlamamodMod.LOGGER.debug("Beta warning message sent.");
		}
	}
}