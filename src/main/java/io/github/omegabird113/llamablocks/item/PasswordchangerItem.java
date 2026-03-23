package io.github.omegabird113.llamablocks.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

import io.github.omegabird113.llamablocks.procedures.PasswordbananaprivlidgeescheckProcedure;
import io.github.omegabird113.llamablocks.procedures.OpenpasswordchangerguiprocedureProcedure;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class PasswordchangerItem extends Item {
	public PasswordchangerItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = LlamamodMod.clientPlayer();
		return PasswordbananaprivlidgeescheckProcedure.execute(entity);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		OpenpasswordchangerguiprocedureProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}