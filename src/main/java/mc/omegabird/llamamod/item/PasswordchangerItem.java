package mc.omegabird.llamamod.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

import mc.omegabird.llamamod.procedures.PasswordbananaprivlidgeescheckProcedure;
import mc.omegabird.llamamod.procedures.OpenpasswordchangerguiprocedureProcedure;
import mc.omegabird.llamamod.LlamamodMod;

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