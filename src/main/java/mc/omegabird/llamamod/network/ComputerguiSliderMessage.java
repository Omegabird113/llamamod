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

import mc.omegabird.llamamod.procedures.GenRandomNumberProcedureProcedure;
import mc.omegabird.llamamod.LlamamodMod;

@EventBusSubscriber
public record ComputerguiSliderMessage(int sliderID, int x, int y, int z, double value) implements CustomPacketPayload {

	public static final Type<ComputerguiSliderMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LlamamodMod.MODID, "computergui_sliders"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ComputerguiSliderMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ComputerguiSliderMessage message) -> {
		buffer.writeInt(message.sliderID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeDouble(message.value);
	}, (RegistryFriendlyByteBuf buffer) -> new ComputerguiSliderMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readDouble()));
	@Override
	public Type<ComputerguiSliderMessage> type() {
		return TYPE;
	}

	public static void handleData(final ComputerguiSliderMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleSliderAction(context.player(), message.sliderID, message.x, message.y, message.z, message.value)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSliderAction(Player entity, int sliderID, int x, int y, int z, double value) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (sliderID == 0) {

			GenRandomNumberProcedureProcedure.execute(entity);
		}
		if (sliderID == 1) {

			GenRandomNumberProcedureProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LlamamodMod.addNetworkMessage(ComputerguiSliderMessage.TYPE, ComputerguiSliderMessage.STREAM_CODEC, ComputerguiSliderMessage::handleData);
	}
}