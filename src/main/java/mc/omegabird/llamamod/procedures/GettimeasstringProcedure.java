package mc.omegabird.llamamod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;

public class GettimeasstringProcedure {
	public static String execute(LevelAccessor world) {
		double twenty_four_hour_hour = 0;
		double percentage_througth_day_night = 0;
		twenty_four_hour_hour = ((world.dayTime() + 6000) % 24000) / 1000d;
		percentage_througth_day_night = (((new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(world.dayTime() % 24000 + ".0") / 24000) * 100) % 50) * 2;
		return Math.round(twenty_four_hour_hour) + " o'clock (" + Math.round(percentage_througth_day_night) + "% through the " + (twenty_four_hour_hour >= 6 && twenty_four_hour_hour <= 18 ? "day" : "night") + ")";
	}
}