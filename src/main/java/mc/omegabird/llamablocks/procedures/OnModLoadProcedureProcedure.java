package mc.omegabird.llamablocks.procedures;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import mc.omegabird.llamablocks.LlamablocksMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OnModLoadProcedureProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		LlamablocksMod.LOGGER.info("LlamaBlocks (modid: \"llamamod\") loaded. Run \"/llamablocks about\" for more info.");
		if (IsThisBetaProcedureProcedure.execute()) {
			LlamablocksMod.LOGGER.warn("WARNING: This is a BETA version of LlamaBlocks and may be unstable.");
		}
		LlamablocksMod.LOGGER.info("LlamaBlocks is made with MCreator, and therefore may have some extra performance issues or bugs.");
		LlamablocksMod.LOGGER.debug(("LlamaBlocks is set to Minecraft Version: " + ReturnMinecraftVersionProcedureProcedure.execute()));
	}
}