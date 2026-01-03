package net.ihavenowebsite.omegabird.llamamod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class LlamamodserverconfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> GENERATE_ACID_LAKES;
	public static final ModConfigSpec.ConfigValue<Double> ACCESS_EXISTING_PASSWORDS_PERMISSION_LEVEL;
	public static final ModConfigSpec.ConfigValue<Boolean> GIVE_ALL_RECIPES_ON_PLAYER_JOIN;
	static {
		BUILDER.push("generation");
		GENERATE_ACID_LAKES = BUILDER.define("generate_acid_lakes", true);
		BUILDER.pop();
		BUILDER.push("permissions");
		ACCESS_EXISTING_PASSWORDS_PERMISSION_LEVEL = BUILDER.comment("This controls the permission level required for people to be able to see the existing password in the Password Changer GUI").define("password_viewing_permission_level",
				(double) 3);
		BUILDER.pop();
		BUILDER.push("misc");
		GIVE_ALL_RECIPES_ON_PLAYER_JOIN = BUILDER.comment("When enabled, this runs /recipe give @a * when an player joins the server or world").define("give_players_all_recipes", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}