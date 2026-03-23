package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import io.github.omegabird113.llamablocks.init.LlamamodModFluids;

public class AcidItem extends BucketItem {
	public AcidItem(Item.Properties properties) {
		super(LlamamodModFluids.ACID.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}