package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

import io.github.omegabird113.llamablocks.procedures.DiamondBannanaPlayerFinishesUsingItemProcedure;
import io.github.omegabird113.llamablocks.init.LlamamodModItems;

public class DiamondBannanaItem extends Item {
	public DiamondBannanaItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(9).saturationModifier(1.2f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 20;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(LlamamodModItems.FARM_SCRAPS.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		DiamondBannanaPlayerFinishesUsingItemProcedure.execute(world, entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}