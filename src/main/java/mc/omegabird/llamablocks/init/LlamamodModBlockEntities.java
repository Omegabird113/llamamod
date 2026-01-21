/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamablocks.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import mc.omegabird.llamablocks.block.entity.SecurestorageblockBlockEntity;
import mc.omegabird.llamablocks.block.entity.ComputerBlockEntity;
import mc.omegabird.llamablocks.block.entity.AuthenticatorblockBlockEntity;
import mc.omegabird.llamablocks.LlamamodMod;

@EventBusSubscriber
public class LlamamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, LlamamodMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ComputerBlockEntity>> COMPUTER = register("computer", LlamamodModBlocks.COMPUTER, ComputerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AuthenticatorblockBlockEntity>> AUTHENTICATOR = register("authenticator", LlamamodModBlocks.AUTHENTICATOR, AuthenticatorblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SecurestorageblockBlockEntity>> SECURE_STORAGE_BLOCK = register("secure_storage_block", LlamamodModBlocks.SECURE_STORAGE_BLOCK, SecurestorageblockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COMPUTER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AUTHENTICATOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SECURE_STORAGE_BLOCK.get(), SidedInvWrapper::new);
	}
}