package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.ihavenowebsite.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class IsItemClearingAllowedProcedureProcedure {
	public static boolean execute() {
		return LlamamodserverconfigConfiguration.ALLOW_ITEM_CLEARING.get();
	}
}