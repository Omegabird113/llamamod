package io.github.omegabird113.llamablocks.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.client.Minecraft;

import io.github.omegabird113.llamablocks.procedures.PasswordbananaprivlidgeescheckProcedure;
import io.github.omegabird113.llamablocks.procedures.OpenpasswordchangerguiprocedureProcedure;

public class PasswordchangerItem extends Item {
	public PasswordchangerItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return PasswordbananaprivlidgeescheckProcedure.execute(entity);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		OpenpasswordchangerguiprocedureProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}