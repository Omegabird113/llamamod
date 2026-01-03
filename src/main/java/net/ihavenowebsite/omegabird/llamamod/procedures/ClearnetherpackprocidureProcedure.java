package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModMenus;
import net.ihavenowebsite.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class ClearnetherpackprocidureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double iteratir = 0;
		if (LlamamodserverconfigConfiguration.ALLOW_ITEM_CLEARING.get()) {
			iteratir = 0;
			while (iteratir <= 35) {
				if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get((int) iteratir).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				iteratir = iteratir + 1;
			}
		}
	}
}