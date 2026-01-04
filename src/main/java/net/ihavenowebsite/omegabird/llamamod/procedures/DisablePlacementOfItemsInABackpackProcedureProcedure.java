package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.ihavenowebsite.omegabird.llamamod.configuration.LlamamodserverconfigConfiguration;

public class DisablePlacementOfItemsInABackpackProcedureProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (LlamamodserverconfigConfiguration.PREVENT_NESTED_BACKPACK_PLACEMENT.get() == true) {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("llamamod:cannot_be_placed_in_backpacks")))) {
				return true;
			}
			return false;
		}
		return false;
	}
}