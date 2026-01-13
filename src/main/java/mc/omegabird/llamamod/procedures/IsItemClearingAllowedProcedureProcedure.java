package mc.omegabird.llamamod.llamamod.procedures;

import mc.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class IsItemClearingAllowedProcedureProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.ALLOW_ITEM_CLEARING.get();
	}
}