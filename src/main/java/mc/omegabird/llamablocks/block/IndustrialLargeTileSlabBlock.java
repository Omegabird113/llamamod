package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class IndustrialLargeTileSlabBlock extends SlabBlock {
	public IndustrialLargeTileSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops());
	}
}