package mc.omegabird.llamablocks.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import mc.omegabird.llamablocks.init.LlamamodModMenus;

public class ComputercalculateprocidureProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double num1 = 0;
		double num2 = 0;
		String result = "";
		String operation = "";
		operation = ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "operation", "") : "").toUpperCase();
		if ((((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "number1", "") : "").toUpperCase()).equals("PI")) {
			num1 = Math.PI;
		} else if ((((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "number1", "") : "").toUpperCase()).equals("E")) {
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
			}.convert((entity instanceof Player _entity3 && _entity3.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "number1", "") : "");
		}
		if ((((entity instanceof Player _entity4 && _entity4.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "number2", "") : "").toUpperCase()).equals("PI")) {
			num2 = Math.PI;
		} else if ((((entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "number2", "") : "").toUpperCase()).equals("E")) {
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
			}.convert((entity instanceof Player _entity6 && _entity6.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(0, "number2", "") : "");
		}
		if ((operation).equals("+")) {
			result = "" + (num1 + num2);
		} else if ((operation).equals("-")) {
			result = "" + (num1 - num2);
		} else if ((operation).equals("*") || (operation).equals("x")) {
			result = "" + num1 * num2;
		} else if ((operation).equals("/")) {
			result = "" + num1 / num2;
		} else if ((operation).equals("^")) {
			result = "" + Math.pow(num1, num2);
		} else if ((operation).equals("MOD")) {
			result = "" + num1 % num2;
		} else if ((operation).equals("MIN")) {
			result = "" + Math.min(num1, num2);
		} else if ((operation).equals("MAX")) {
			result = "" + Math.max(num1, num2);
		} else if ((operation).equals("ATAN2")) {
			result = "" + Math.atan2(num1, num2);
		} else if ((operation).equals("HYPOT")) {
			result = "" + Math.hypot(num1, num2);
		} else if ((operation).equals("AND")) {
			result = "" + ((int) num1 & (int) num2);
		} else if ((operation).equals("OR")) {
			result = "" + ((int) num1 | (int) num2);
		} else if ((operation).equals("XOR")) {
			result = "" + ((int) num1 ^ (int) num2);
		} else if ((operation).equals("LOG")) {
			result = "" + Math.log(num2) / Math.log(num1);
		} else {
			if ((operation).equals("NLOG")) {
				result = "" + Math.log(num1);
			} else if ((operation).equals("ROUND")) {
				result = "" + Math.round(num1);
			} else if ((operation).equals("CEIL")) {
				result = "" + Math.ceil(num1);
			} else if ((operation).equals("FLOOR")) {
				result = "" + Math.floor(num1);
			} else if ((operation).equals("SQRT") || (operation).equals("2ROOT")) {
				result = "" + Math.sqrt(num1);
			} else if ((operation).equals("3ROOT")) {
				result = "" + Math.cbrt(num1);
			} else if ((operation).equals("ABS")) {
				result = "" + Math.abs(num1);
			} else if ((operation).equals("SIGNUM")) {
				result = "" + Math.signum(num1);
			} else if ((operation).equals("SIN")) {
				result = "" + Math.sin(num1);
			} else if ((operation).equals("COS")) {
				result = "" + Math.cos(num1);
			} else if ((operation).equals("TAN")) {
				result = "" + Math.tan(num1);
			} else if ((operation).equals("ASIN")) {
				result = "" + Math.asin(num1);
			} else if ((operation).equals("ACOS")) {
				result = "" + Math.acos(num1);
			} else if ((operation).equals("ATAN")) {
				result = "" + Math.atan(num1);
			} else if ((operation).equals("RAD>DEG")) {
				result = "" + Math.toDegrees(num1);
			} else if ((operation).equals("DEG>RAD")) {
				result = "" + Math.toRadians(num1);
			} else {
				result = "Invalid operator";
			}
		}
		return result;
	}
}