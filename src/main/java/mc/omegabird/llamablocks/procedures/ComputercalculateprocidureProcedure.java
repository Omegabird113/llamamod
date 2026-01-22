package mc.omegabird.llamablocks.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import mc.omegabird.llamablocks.init.LlamamodModMenus;

public class ComputercalculateprocidureProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String result = "";
		double num1 = 0;
		double num2 = 0;
		if ((((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "number1", "") : "").toUpperCase()).equals("PI")) {
			num1 = Math.PI;
		} else if ((((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "number1", "") : "").toUpperCase()).equals("E")) {
			num1 = Math.E;
		} else {
			num1 = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "number1", "") : "");
		}
		if ((((entity instanceof Player _entity3 && _entity3.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "number2", "") : "").toUpperCase()).equals("PI")) {
			num2 = Math.PI;
		} else if ((((entity instanceof Player _entity4 && _entity4.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "number2", "") : "").toUpperCase()).equals("E")) {
			num2 = Math.E;
		} else {
			num2 = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "number2", "") : "");
		}
		if (((entity instanceof Player _entity6 && _entity6.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(0, "operation", "") : "").equals("+")) {
			result = "" + (num1 + num2);
		} else if (((entity instanceof Player _entity7 && _entity7.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(0, "operation", "") : "").equals("-")) {
			result = "" + (num1 - num2);
		} else if (((entity instanceof Player _entity8 && _entity8.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(0, "operation", "") : "").equals("*")
				|| ((entity instanceof Player _entity9 && _entity9.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "operation", "") : "").equals("x")) {
			result = "" + num1 * num2;
		} else if (((entity instanceof Player _entity10 && _entity10.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(0, "operation", "") : "").equals("/")) {
			result = "" + num1 / num2;
		} else if (((entity instanceof Player _entity11 && _entity11.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu11) ? _menu11.getMenuState(0, "operation", "") : "").equals("^")) {
			result = "" + Math.pow(num1, num2);
		} else if ((((entity instanceof Player _entity12 && _entity12.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu12) ? _menu12.getMenuState(0, "operation", "") : "").toUpperCase()).equals("MOD")) {
			result = "" + num1 % num2;
		} else if ((((entity instanceof Player _entity13 && _entity13.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu13) ? _menu13.getMenuState(0, "operation", "") : "").toUpperCase()).equals("MIN")) {
			result = "" + Math.min(num1, num2);
		} else if ((((entity instanceof Player _entity14 && _entity14.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu14) ? _menu14.getMenuState(0, "operation", "") : "").toUpperCase()).equals("MAX")) {
			result = "" + Math.max(num1, num2);
		} else if ((((entity instanceof Player _entity15 && _entity15.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu15) ? _menu15.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ATAN2")) {
			result = "" + Math.atan2(num1, num2);
		} else if ((((entity instanceof Player _entity16 && _entity16.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu16) ? _menu16.getMenuState(0, "operation", "") : "").toUpperCase()).equals("HYPOT")) {
			result = "" + Math.hypot(num1, num2);
		} else if ((((entity instanceof Player _entity17 && _entity17.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu17) ? _menu17.getMenuState(0, "operation", "") : "").toUpperCase()).equals("AND")) {
			result = "" + ((int) num1 & (int) num2);
		} else if ((((entity instanceof Player _entity18 && _entity18.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu18) ? _menu18.getMenuState(0, "operation", "") : "").toUpperCase()).equals("OR")) {
			result = "" + ((int) num1 | (int) num2);
		} else if ((((entity instanceof Player _entity19 && _entity19.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu19) ? _menu19.getMenuState(0, "operation", "") : "").toUpperCase()).equals("XOR")) {
			result = "" + ((int) num1 ^ (int) num2);
		} else if ((((entity instanceof Player _entity20 && _entity20.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu20) ? _menu20.getMenuState(0, "operation", "") : "").toUpperCase()).equals("LOG")) {
			result = "" + Math.log(num2) / Math.log(num1);
		} else {
			result = "Invalid operator";
		}
		return result;
	}
}