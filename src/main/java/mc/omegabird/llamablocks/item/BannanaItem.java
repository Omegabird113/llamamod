package mc.omegabird.llamablocks.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class BannanaItem extends Item {
	public BannanaItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(4.1f).build(), Consumables.defaultFood().consumeSeconds(0.6F).build()));
	}
}