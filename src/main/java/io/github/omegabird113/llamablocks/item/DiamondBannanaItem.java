package io.github.omegabird113.llamablocks.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.component.DataComponents;

import io.github.omegabird113.llamablocks.procedures.DiamondBannanaPlayerFinishesUsingItemProcedure;
import io.github.omegabird113.llamablocks.init.LlamamodModItems;

@EventBusSubscriber
public class DiamondBannanaItem extends Item {
	public DiamondBannanaItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).fireResistant().food((new FoodProperties.Builder()).nutrition(9).saturationModifier(3.4f).build(), Consumables.defaultFood().consumeSeconds(1F).build()));
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		event.modify(LlamamodModItems.DIAMOND_BANNANA.get(), (builder, _, _) -> builder.set(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(LlamamodModItems.FARM_SCRAPS.get()))));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		DiamondBannanaPlayerFinishesUsingItemProcedure.execute(world, entity);
		return retval;
	}
}