package mc.omegabird.llamablocks.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GoldenBannanaItem extends Item {
	public GoldenBannanaItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(5).saturationModifier(12.2f).build(), Consumables.defaultFood().consumeSeconds(0.95F).build()));
	}
}