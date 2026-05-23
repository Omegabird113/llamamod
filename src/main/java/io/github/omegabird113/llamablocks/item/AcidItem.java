package io.github.omegabird113.llamablocks.item;

import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

import io.github.omegabird113.llamablocks.init.LlamamodModFluids;

public class AcidItem extends BucketItem {
	public AcidItem() {
		super(LlamamodModFluids.ACID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		return new FluidBucketWrapper(stack);
	}
}