package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class BannanaItem extends Item {
	public BannanaItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.8f).build(), Consumables.defaultFood().consumeSeconds(0.55F).build()));
	}
}