package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class CeilingtilestairBlock extends StairBlock {
	public CeilingtilestairBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.mapColor(MapColor.ICE).sound(SoundType.METAL).strength(19f, 33f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 33f;
	}
}