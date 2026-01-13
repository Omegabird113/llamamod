package mc.omegabird.llamamod.procedures;

import mc.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class BananapatchAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.GENERATE_BANANA_PATCHES.get();
	}
}