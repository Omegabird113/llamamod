package mc.omegabird.llamamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Ifplayerhaspermission2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player _playerCmd0 && _playerCmd0.hasPermissions(2)) {
			return true;
		}
		return false;
	}
}