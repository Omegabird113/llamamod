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

import io.github.omegabird113.llamablocks.procedures.XbuttonprocidureProcedure;
import io.github.omegabird113.llamablocks.procedures.AuthProcedureProcedure;
import io.github.omegabird113.llamablocks.LlamamodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record AuthGUIButtonMessage(int buttonID, int x, int y, int z) {
	public AuthGUIButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void buffer(AuthGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AuthGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			AuthProcedureProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			XbuttonprocidureProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LlamamodMod.addNetworkMessage(AuthGUIButtonMessage.class, AuthGUIButtonMessage::buffer, AuthGUIButtonMessage::new, AuthGUIButtonMessage::handler);
	}
}