package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.ihavenowebsite.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class AcidLakeGenerationConditionProcedureProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.GENERATE_ACID_LAKES.get();
	}
}