/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.llamamod.init;

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

import net.mcreator.llamamod.block.entity.SecurestorageblockBlockEntity;
import net.mcreator.llamamod.block.entity.ComputerBlockEntity;
import net.mcreator.llamamod.block.entity.AuthenticatorblockBlockEntity;
import net.mcreator.llamamod.LlamaModMod;

@EventBusSubscriber
public class LlamaModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, LlamaModMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ComputerBlockEntity>> COMPUTER = register("computer", LlamaModModBlocks.COMPUTER, ComputerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AuthenticatorblockBlockEntity>> AUTHENTICATORBLOCK = register("authenticatorblock", LlamaModModBlocks.AUTHENTICATORBLOCK, AuthenticatorblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SecurestorageblockBlockEntity>> SECURESTORAGEBLOCK = register("securestorageblock", LlamaModModBlocks.SECURESTORAGEBLOCK, SecurestorageblockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COMPUTER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AUTHENTICATORBLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SECURESTORAGEBLOCK.get(), SidedInvWrapper::new);
	}
}