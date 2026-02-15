package mc.omegabird.llamablocks.procedures;

import net.minecraft.network.chat.Component;

public class ReturnNOBETALlamaModVersionProcedureProcedure {
	public static String execute() {
		return Component.translatable("llamamod.about.version.excludebeta").getString();
	}
}