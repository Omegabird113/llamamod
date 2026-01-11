package mc.omegabird.llamamod.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import mc.omegabird.llamamod.world.inventory.NetherbackpackguiMenu;
import mc.omegabird.llamamod.init.LlamamodModItems;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class NetheritebackpackInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == LlamamodModItems.NETHERITE_BACKPACK.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof NetherbackpackguiMenu)
				player.closeContainer();
		}
	}

	public NetheritebackpackInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 36);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != LlamamodModItems.NETHERITE_BACKPACK.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}