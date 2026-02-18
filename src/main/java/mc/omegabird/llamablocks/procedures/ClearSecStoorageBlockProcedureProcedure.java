package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import mc.omegabird.llamablocks.init.LlamablocksModMenus;
import mc.omegabird.llamablocks.init.LlamablocksModGameRules;

public class ClearSecStoorageBlockProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double iteratir = 0;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(LlamablocksModGameRules.ALLOW_ITEM_DELETION)) {
			iteratir = 0;
			while (iteratir <= 62) {
				if (entity instanceof Player _player && _player.containerMenu instanceof LlamablocksModMenus.MenuAccessor _menu) {
					_menu.getSlots().get((int) iteratir).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				iteratir = iteratir + 1;
			}
		}
	}
}