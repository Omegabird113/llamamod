package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GettimeasstringProcedure {
	public static String execute(LevelAccessor world) {
		double twenty_four_hour_hour = 0;
		double percentage_througth_day_night = 0;
		double gametime = 0;
		double daytime = 0;
		double minute = 0;
		double twelve_hour_hour = 0;
		String am_or_pm = "";
		gametime = world.dayTime();
		daytime = gametime % 24000;
		twenty_four_hour_hour = (gametime / 1000 + 6) % 24;
		minute = (twenty_four_hour_hour - Math.floor(twenty_four_hour_hour)) * 60;
		percentage_througth_day_night = (((daytime / 24000) * 100) % 50) * 2;
		if (Math.floor(twenty_four_hour_hour) == 0) {
			twelve_hour_hour = 12;
			am_or_pm = "AM";
		} else if (Math.floor(twenty_four_hour_hour) < 12) {
			twelve_hour_hour = Math.floor(twenty_four_hour_hour);
			am_or_pm = "AM";
		} else if (Math.floor(twenty_four_hour_hour) == 12) {
			twelve_hour_hour = 12;
			am_or_pm = "PM";
		} else {
			twelve_hour_hour = Math.floor(twenty_four_hour_hour) - 12;
			am_or_pm = "PM";
		}
		return new java.text.DecimalFormat("#0").format(twelve_hour_hour) + ":" + new java.text.DecimalFormat("00").format(Math.floor(minute)) + " " + am_or_pm + " (" + new java.text.DecimalFormat("#0.0").format(percentage_througth_day_night)
				+ "% through the " + (daytime < 12000 ? "day" : "night") + ")";
	}
}