package net.mcreator.llamamod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class GettimeasstringProcedure {
	public static String execute(LevelAccessor world) {
		return Math.round(((world.dayTime() + 6000) % 24000) / 1000) + " o'clock (" + Math.round((((new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(world.dayTime() % 24000 + ".0") / 24000) * 100) % 50) * 2) + "% through the " + (world instanceof Level _lvl2 && _lvl2.isBrightOutside() ? "day" : "night") + ")";
	}
}