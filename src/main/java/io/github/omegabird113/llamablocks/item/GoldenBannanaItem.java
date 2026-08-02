package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import io.github.omegabird113.llamablocks.procedures.GoldenBannanaPlayerFinishesUsingItemProcedure;

public class GoldenBannanaItem extends Item {
	public GoldenBannanaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(5).saturationModifier(3f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 18;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		GoldenBannanaPlayerFinishesUsingItemProcedure.execute(world, entity);
		return retval;
	}
}