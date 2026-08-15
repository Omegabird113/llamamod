/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;

import io.github.omegabird113.llamablocks.block.entity.SecurestorageblockBlockEntity;
import io.github.omegabird113.llamablocks.block.entity.ComputerBlockEntity;
import io.github.omegabird113.llamablocks.block.entity.AuthenticatorblockBlockEntity;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LlamamodMod.MODID);
	public static final RegistryObject<BlockEntityType<ComputerBlockEntity>> COMPUTER = register("computer", LlamamodModBlocks.COMPUTER, ComputerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<AuthenticatorblockBlockEntity>> AUTHENTICATOR = register("authenticator", LlamamodModBlocks.AUTHENTICATOR, AuthenticatorblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<SecurestorageblockBlockEntity>> SECURE_STORAGE_BLOCK = register("secure_storage_block", LlamamodModBlocks.SECURE_STORAGE_BLOCK, SecurestorageblockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}