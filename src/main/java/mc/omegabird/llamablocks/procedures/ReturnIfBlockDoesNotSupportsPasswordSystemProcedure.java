package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ReturnIfBlockDoesNotSupportsPasswordSystemProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("llamamod:supports_password_system")));
	}
}