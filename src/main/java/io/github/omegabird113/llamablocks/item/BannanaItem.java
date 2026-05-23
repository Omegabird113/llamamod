package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class BannanaItem extends Item {
	public BannanaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(3.65f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 13;
	}
}