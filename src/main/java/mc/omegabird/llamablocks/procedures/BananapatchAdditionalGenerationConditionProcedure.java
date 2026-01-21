package mc.omegabird.llamablocks.procedures;

import mc.omegabird.llamablocks.configuration.LlamamodserverconfigConfiguration;

public class BananapatchAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.GENERATE_BANANA_PATCHES.get();
	}
}