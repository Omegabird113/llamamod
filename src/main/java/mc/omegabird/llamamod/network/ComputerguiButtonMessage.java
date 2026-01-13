package mc.omegabird.llamamod.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import mc.omegabird.llamamod.procedures.*;
import mc.omegabird.llamamod.LlamamodMod;

@EventBusSubscriber
public record ComputerguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ComputerguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LlamamodMod.MODID, "computergui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ComputerguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ComputerguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ComputerguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ComputerguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ComputerguiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			XbuttonprocidureProcedure.execute(entity);
		}
		if (buttonID == 1) {

			CompClearInventoryOfPlayerXProcedureProcedure.execute(world, entity);
		}
		if (buttonID == 2) {

			CompkillplayerXprocedureProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			LoadmeassageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SavemeassageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			CompsendmsgprocidureProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			GenRandomNumberProcedureProcedure.execute(entity);
		}
		if (buttonID == 7) {

			SetComputerRedstoneOutputPowerLevelProcedureProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SetRANDOMComputerRedstoneOutputPowerLevelProcedureProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LlamamodMod.addNetworkMessage(ComputerguiButtonMessage.TYPE, ComputerguiButtonMessage.STREAM_CODEC, ComputerguiButtonMessage::handleData);
	}
}