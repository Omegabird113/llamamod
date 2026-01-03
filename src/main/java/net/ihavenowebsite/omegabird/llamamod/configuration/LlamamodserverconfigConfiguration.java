package net.ihavenowebsite.omegabird.llamamod.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class LlamamodserverconfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> GENERATE_ACID_LAKES;
	public static final ModConfigSpec.ConfigValue<Double> ACCESS_EXISTING_PASSWORDS_PERMISSION_LEVEL;
	static {
		BUILDER.push("generation");
		GENERATE_ACID_LAKES = BUILDER.define("generate_acid_lakes", true);
		BUILDER.pop();
		BUILDER.push("permissions");
		ACCESS_EXISTING_PASSWORDS_PERMISSION_LEVEL = BUILDER.comment("This controls the permission level required for people to be able to see the existing password in the Password Changer GUI").define("password_viewing_permission_level",
				(double) 3);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}