package mc.omegabird.llamamod.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import mc.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class PasswordbananaprivlidgeescheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (getEntityGameType(entity) == GameType.CREATIVE && entity instanceof Player _playerCmd2 && _playerCmd2.hasPermissions((int) (double) LlamamodserverconfigConfiguration.ACCESS_EXISTING_PASSWORDS_PERMISSION_LEVEL.get())) {
			return true;
		}
		return false;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}