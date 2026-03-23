package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;
import io.github.omegabird113.llamablocks.init.LlamamodModGameRules;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class ClearnetherpackprocidureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double iteratir = 0;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(LlamamodModGameRules.ALLOW_ITEM_DELETION)) {
			iteratir = 0;
			while (iteratir <= 35) {
				if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get((int) iteratir).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				iteratir = iteratir + 1;
			}
			LlamamodMod.LOGGER.debug("Netherite Backpack cleared");
		}
	}
}