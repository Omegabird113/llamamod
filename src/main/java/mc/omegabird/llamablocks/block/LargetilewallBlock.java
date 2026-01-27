package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class LargetilewallBlock extends WallBlock {
	public LargetilewallBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.QUARTZ).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}