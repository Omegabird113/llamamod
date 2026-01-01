package net.mcreator.llamamod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.llamamod.init.LlamaModModMenus;

public class ComputercalculateprocidureProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double result = 0;
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "operation", "") : "").equals("+")) {
			result = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "number1", "") : "") + new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "number2", "") : "");
		} else if (((entity instanceof Player _entity3 && _entity3.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "operation", "") : "").equals("-")) {
			result = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity4 && _entity4.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "number1", "") : "") - new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "number2", "") : "");
		} else if (((entity instanceof Player _entity6 && _entity6.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(0, "operation", "") : "").equals("*")
				|| ((entity instanceof Player _entity7 && _entity7.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(0, "operation", "") : "").equals("x")) {
			result = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity8 && _entity8.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(0, "number1", "") : "") * new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity9 && _entity9.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "number2", "") : "");
		} else if (((entity instanceof Player _entity10 && _entity10.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(0, "operation", "") : "").equals("/")) {
			result = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity11 && _entity11.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu11) ? _menu11.getMenuState(0, "number1", "") : "") / new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity12 && _entity12.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu12) ? _menu12.getMenuState(0, "number2", "") : "");
		} else if (((entity instanceof Player _entity13 && _entity13.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu13) ? _menu13.getMenuState(0, "operation", "") : "").equals("^")) {
			result = Math.pow(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity14 && _entity14.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu14) ? _menu14.getMenuState(0, "number1", "") : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity15 && _entity15.containerMenu instanceof LlamaModModMenus.MenuAccessor _menu15) ? _menu15.getMenuState(0, "number2", "") : ""));
		} else {
			result = 0;
		}
		return "" + result;
	}
}