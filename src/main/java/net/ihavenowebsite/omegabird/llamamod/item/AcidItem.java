package net.ihavenowebsite.omegabird.llamamod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModFluids;

public class AcidItem extends BucketItem {
	public AcidItem(Item.Properties properties) {
		super(LlamamodModFluids.ACID.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}