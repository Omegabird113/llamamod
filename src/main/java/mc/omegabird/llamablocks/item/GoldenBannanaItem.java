package mc.omegabird.llamablocks.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GoldenBannanaItem extends Item {
	public GoldenBannanaItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(32).food((new FoodProperties.Builder()).nutrition(5).saturationModifier(12.2f).build(), Consumables.defaultFood().consumeSeconds(0.9F).build()));
	}
}