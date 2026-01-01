package net.mcreator.llamamod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.llamamod.init.LlamaModModFluids;

public class AcidItem extends BucketItem {
	public AcidItem(Item.Properties properties) {
		super(LlamaModModFluids.ACID.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}