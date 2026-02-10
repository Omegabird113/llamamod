package mc.omegabird.llamablocks.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import mc.omegabird.llamablocks.procedures.GoldenBannanaPlayerFinishesUsingItemProcedure;

public class GoldenBannanaItem extends Item {
	public GoldenBannanaItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(5).saturationModifier(7.1f).build(), Consumables.defaultFood().consumeSeconds(1F).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		GoldenBannanaPlayerFinishesUsingItemProcedure.execute(world, entity);
		return retval;
	}
}