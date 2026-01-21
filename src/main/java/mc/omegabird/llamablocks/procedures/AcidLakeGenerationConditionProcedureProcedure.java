package mc.omegabird.llamablocks.procedures;

import mc.omegabird.llamablocks.configuration.LlamamodserverconfigConfiguration;

public class AcidLakeGenerationConditionProcedureProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.GENERATE_ACID_LAKES.get();
	}
}