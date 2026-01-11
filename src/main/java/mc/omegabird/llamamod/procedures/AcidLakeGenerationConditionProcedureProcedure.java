package mc.omegabird.llamamod.procedures;

import mc.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class AcidLakeGenerationConditionProcedureProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.GENERATE_ACID_LAKES.get();
	}
}