package mc.omegabird.llamablocks.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import mc.omegabird.llamablocks.init.LlamamodModFluids;

public class AcidItem extends BucketItem {
	public AcidItem() {
		super(LlamamodModFluids.ACID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}