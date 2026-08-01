package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DiamondBananaUpgradeTemplateItem extends Item {
	public DiamondBananaUpgradeTemplateItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).fireResistant());
	}
}