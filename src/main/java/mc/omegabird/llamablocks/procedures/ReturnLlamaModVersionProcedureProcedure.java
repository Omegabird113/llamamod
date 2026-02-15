package mc.omegabird.llamablocks.procedures;

import net.minecraft.network.chat.Component;

public class ReturnLlamaModVersionProcedureProcedure {
	public static String execute() {
		return Component.translatable("llamamod.about.version").getString();
	}
}