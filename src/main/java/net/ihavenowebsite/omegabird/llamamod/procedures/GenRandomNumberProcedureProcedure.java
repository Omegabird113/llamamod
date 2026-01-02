package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModMenus;

public class GenRandomNumberProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) && _menu0.getMenuState(1, "includedRand", false)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "result",
						("" + (Mth.nextInt(RandomSource.create(), (int) ((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(2, "minimumRand", 0.0) : 0.0),
								(int) ((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(2, "maximumRand", 0.0) : 0.0)))),
						true);
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "result",
						("" + (Mth.nextDouble(RandomSource.create(), (entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(2, "minimumRand", 0.0) : 0.0,
								(entity instanceof Player _entity6 && _entity6.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(2, "maximumRand", 0.0) : 0.0))),
						true);
		}
	}
}