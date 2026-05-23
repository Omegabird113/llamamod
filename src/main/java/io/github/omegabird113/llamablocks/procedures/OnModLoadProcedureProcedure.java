package io.github.omegabird113.llamablocks.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import io.github.omegabird113.llamablocks.LlamamodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OnModLoadProcedureProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		LlamamodMod.LOGGER.info("LlamaBlocks (modid: \"llamamod\") loaded. Run \"/llamablocks about\" for more info.");
		if (IsThisBetaProcedureProcedure.execute()) {
			LlamamodMod.LOGGER.warn("WARNING: This is a BETA version of LlamaBlocks and may be unstable.");
		}
		LlamamodMod.LOGGER.info("LlamaBlocks is made with MCreator, and therefore may have some extra performance issues or bugs.");
		LlamamodMod.LOGGER.debug(("LlamaBlocks is set to Minecraft Version: " + ReturnMinecraftVersionProcedureProcedure.execute()));
	}
}