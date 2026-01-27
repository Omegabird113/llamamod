package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class BlackLargeTileSlabBlock extends SlabBlock {
	public BlackLargeTileSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BLACK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}