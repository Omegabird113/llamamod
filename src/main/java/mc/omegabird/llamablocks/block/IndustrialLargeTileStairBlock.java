package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class IndustrialLargeTileStairBlock extends StairBlock {
	public IndustrialLargeTileStairBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 86.5f;
	}
}