package io.github.omegabird113.llamablocks.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.SectionPos;

import java.util.function.Supplier;

import io.github.omegabird113.llamablocks.procedures.*;
import io.github.omegabird113.llamablocks.LlamamodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record ComputerguiButtonMessage(int buttonID, int x, int y, int z) {
	public ComputerguiButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void buffer(ComputerguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ComputerguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> handleButtonAction(context.getSender(), message.buttonID, message.x, message.y, message.z));
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			XbuttonprocidureProcedure.execute(entity);
		}
		if (buttonID == 1) {

			CompkillplayerXprocedureProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			SetComputerRedstoneOutputPowerLevelProcedureProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetRANDOMComputerRedstoneOutputPowerLevelProcedureProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			CompsendmsgprocidureProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			ComputercalculateprocidureProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			CompClearInventoryOfPlayerXProcedureProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			ComputerguiClearTextboxesProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LlamamodMod.addNetworkMessage(ComputerguiButtonMessage.class, ComputerguiButtonMessage::buffer, ComputerguiButtonMessage::new, ComputerguiButtonMessage::handler);
	}
}