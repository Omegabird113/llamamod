package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import mc.omegabird.llamablocks.init.LlamamodModGameRules;

public class DisablePlacementOfItemsInABackpackProcedureProcedure {
	public static boolean execute(LevelAccessor world, ItemStack itemstack) {
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(LlamamodModGameRules.PREVENT_NESTED_STORAGE_ITEMS)) {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("llamamod:cannot_be_placed_in_storage_items")))) {
				return true;
			}
			return false;
		}
		return false;
	}
}