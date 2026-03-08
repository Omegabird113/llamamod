package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class BrownLargeTileSlabBlock extends SlabBlock {
	public BrownLargeTileSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}