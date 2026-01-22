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
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "operation", "") : "").equals("+")) {
			result = "" + (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "number1", "") : "") + new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity2 && _entity2.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "number2", "") : ""));
		} else if (((entity instanceof Player _entity3 && _entity3.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "operation", "") : "").equals("-")) {
			result = "" + (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity4 && _entity4.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "number1", "") : "") - new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity5 && _entity5.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "number2", "") : ""));
		} else if (((entity instanceof Player _entity6 && _entity6.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(0, "operation", "") : "").equals("*")
				|| ((entity instanceof Player _entity7 && _entity7.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(0, "operation", "") : "").equals("x")) {
			result = "" + (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity8 && _entity8.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(0, "number1", "") : "") * new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity9 && _entity9.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "number2", "") : ""));
		} else if (((entity instanceof Player _entity10 && _entity10.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(0, "operation", "") : "").equals("/")) {
			result = "" + (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity11 && _entity11.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu11) ? _menu11.getMenuState(0, "number1", "") : "") / new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity12 && _entity12.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu12) ? _menu12.getMenuState(0, "number2", "") : ""));
		} else if (((entity instanceof Player _entity13 && _entity13.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu13) ? _menu13.getMenuState(0, "operation", "") : "").equals("^")) {
			result = "" + Math.pow(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity14 && _entity14.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu14) ? _menu14.getMenuState(0, "number1", "") : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity15 && _entity15.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu15) ? _menu15.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity16 && _entity16.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu16) ? _menu16.getMenuState(0, "operation", "") : "").toUpperCase()).equals("MOD")) {
			result = "" + (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity17 && _entity17.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu17) ? _menu17.getMenuState(0, "number1", "") : "") % new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity18 && _entity18.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu18) ? _menu18.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity19 && _entity19.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu19) ? _menu19.getMenuState(0, "operation", "") : "").toUpperCase()).equals("MIN")) {
			result = "" + Math.min(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity20 && _entity20.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu20) ? _menu20.getMenuState(0, "number1", "") : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity21 && _entity21.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity22 && _entity22.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu22) ? _menu22.getMenuState(0, "operation", "") : "").toUpperCase()).equals("MAX")) {
			result = "" + Math.max(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity23 && _entity23.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu23) ? _menu23.getMenuState(0, "number1", "") : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity24 && _entity24.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu24) ? _menu24.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity25 && _entity25.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu25) ? _menu25.getMenuState(0, "operation", "") : "").toUpperCase()).equals("ATAN2")) {
			result = "" + Math.atan2(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity26 && _entity26.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu26) ? _menu26.getMenuState(0, "number1", "") : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity27 && _entity27.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu27) ? _menu27.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity28 && _entity28.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu28) ? _menu28.getMenuState(0, "operation", "") : "").toUpperCase()).equals("HYPOT")) {
			result = "" + Math.hypot(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity29 && _entity29.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu29) ? _menu29.getMenuState(0, "number1", "") : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity30 && _entity30.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu30) ? _menu30.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity31 && _entity31.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu31) ? _menu31.getMenuState(0, "operation", "") : "").toUpperCase()).equals("AND")) {
			result = "" + ((int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity32 && _entity32.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu32) ? _menu32.getMenuState(0, "number1", "") : "") & (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity33 && _entity33.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu33) ? _menu33.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity34 && _entity34.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu34) ? _menu34.getMenuState(0, "operation", "") : "").toUpperCase()).equals("OR")) {
			result = "" + ((int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity35 && _entity35.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu35) ? _menu35.getMenuState(0, "number1", "") : "") | (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity36 && _entity36.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu36) ? _menu36.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity37 && _entity37.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu37) ? _menu37.getMenuState(0, "operation", "") : "").toUpperCase()).equals("XOR")) {
			result = "" + ((int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity38 && _entity38.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu38) ? _menu38.getMenuState(0, "number1", "") : "") ^ (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity39 && _entity39.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu39) ? _menu39.getMenuState(0, "number2", "") : ""));
		} else if ((((entity instanceof Player _entity40 && _entity40.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu40) ? _menu40.getMenuState(0, "operation", "") : "").toUpperCase()).equals("LOG")) {
			result = "" + ((int) Math.log(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity41 && _entity41.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu41) ? _menu41.getMenuState(0, "number2", "") : "")) ^ (int) Math.log(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity42 && _entity42.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu42) ? _menu42.getMenuState(0, "number1", "") : "")));
		} else {
			result = "Invalid operator";
		}
		return result;
	}
}