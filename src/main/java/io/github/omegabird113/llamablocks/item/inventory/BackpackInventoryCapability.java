package io.github.omegabird113.llamablocks.item.inventory;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import io.github.omegabird113.llamablocks.world.inventory.BackpackguiMenu;
import io.github.omegabird113.llamablocks.init.LlamamodModItems;

@Mod.EventBusSubscriber
public class BackpackInventoryCapability implements ICapabilitySerializable<CompoundTag> {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == LlamamodModItems.BACKPACK.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof BackpackguiMenu)
				player.closeContainer();
		}
	}

	private final LazyOptional<ItemStackHandler> inventory = LazyOptional.of(this::createItemHandler);

	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
		return capability == ForgeCapabilities.ITEM_HANDLER ? this.inventory.cast() : LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		return getItemHandler().serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		getItemHandler().deserializeNBT(nbt);
	}

	private ItemStackHandler createItemHandler() {
		return new ItemStackHandler(27) {
			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return stack.getItem() != LlamamodModItems.BACKPACK.get();
			}

			@Override
			public void setSize(int size) {
			}
		};
	}

	private ItemStackHandler getItemHandler() {
		return inventory.orElseThrow(RuntimeException::new);
	}
}