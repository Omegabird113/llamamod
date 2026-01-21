package mc.omegabird.llamablocks.procedures;

import mc.omegabird.llamablocks.configuration.LlamamodserverconfigConfiguration;

public class IsItemClearingAllowedProcedureProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.ALLOW_ITEM_CLEARING.get();
	}
}