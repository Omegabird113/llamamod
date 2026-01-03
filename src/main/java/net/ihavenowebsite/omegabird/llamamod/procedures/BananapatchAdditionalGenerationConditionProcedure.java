package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.ihavenowebsite.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class BananapatchAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.GENERATE_BANANA_PATCHES.get();
	}
}