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
			if ((((entity instanceof Player _entity21 && _entity21.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(0, "operation", "") : "").toUpperCase()).equals("NLOG")) {
				result = "" + Math.log(num1);
			} else if ((((entity instanceof Player _entity22 && _entity22.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu22) ? _menu22.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ROUND")) {
				result = "" + Math.round(num1);
			} else if ((((entity instanceof Player _entity23 && _entity23.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu23) ? _menu23.getMenuState(0, "operation", "") : "").toUpperCase()).equals("CEIL")) {
				result = "" + Math.ceil(num1);
			} else if ((((entity instanceof Player _entity24 && _entity24.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu24) ? _menu24.getMenuState(0, "operation", "") : "").toUpperCase()).equals("FLOOR")) {
				result = "" + Math.floor(num1);
			} else if ((((entity instanceof Player _entity25 && _entity25.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu25) ? _menu25.getMenuState(0, "operation", "") : "").toUpperCase()).equals("SQRT")
					|| (((entity instanceof Player _entity26 && _entity26.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu26) ? _menu26.getMenuState(0, "operation", "") : "").toUpperCase()).equals("2ROOT")) {
				result = "" + Math.sqrt(num1);
			} else if ((((entity instanceof Player _entity27 && _entity27.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu27) ? _menu27.getMenuState(0, "operation", "") : "").toUpperCase()).equals("3ROOT")) {
				result = "" + Math.cbrt(num1);
			} else if ((((entity instanceof Player _entity28 && _entity28.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu28) ? _menu28.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ABS")) {
				result = "" + Math.abs(num1);
			} else if ((((entity instanceof Player _entity29 && _entity29.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu29) ? _menu29.getMenuState(0, "operation", "") : "").toUpperCase()).equals("SIGNUM")) {
				result = "" + Math.signum(num1);
			} else if ((((entity instanceof Player _entity30 && _entity30.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu30) ? _menu30.getMenuState(0, "operation", "") : "").toUpperCase()).equals("SIN")) {
				result = "" + Math.sin(num1);
			} else if ((((entity instanceof Player _entity31 && _entity31.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu31) ? _menu31.getMenuState(0, "operation", "") : "").toUpperCase()).equals("COS")) {
				result = "" + Math.cos(num1);
			} else if ((((entity instanceof Player _entity32 && _entity32.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu32) ? _menu32.getMenuState(0, "operation", "") : "").toUpperCase()).equals("TAN")) {
				result = "" + Math.tan(num1);
			} else if ((((entity instanceof Player _entity33 && _entity33.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu33) ? _menu33.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ASIN")) {
				result = "" + Math.asin(num1);
			} else if ((((entity instanceof Player _entity34 && _entity34.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu34) ? _menu34.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ACOS")) {
				result = "" + Math.acos(num1);
			} else if ((((entity instanceof Player _entity35 && _entity35.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu35) ? _menu35.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ATAN")) {
				result = "" + Math.atan(num1);
			} else if ((((entity instanceof Player _entity36 && _entity36.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu36) ? _menu36.getMenuState(0, "operation", "") : "").toUpperCase()).equals("RAD>DEG")) {
				result = "" + Math.toDegrees(num1);
			} else if ((((entity instanceof Player _entity37 && _entity37.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu37) ? _menu37.getMenuState(0, "operation", "") : "").toUpperCase()).equals("DEG>RAD")) {
				result = "" + Math.toRadians(num1);
			} else {
				result = "Invalid operator";
			}
		}
		return result;
	}
}