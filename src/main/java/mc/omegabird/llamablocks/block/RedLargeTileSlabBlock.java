package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class RedLargeTileSlabBlock extends SlabBlock {
	public RedLargeTileSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_RED).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}