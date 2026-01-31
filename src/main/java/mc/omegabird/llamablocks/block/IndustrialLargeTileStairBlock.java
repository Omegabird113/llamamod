package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class IndustrialLargeTileStairBlock extends StairBlock {
	public IndustrialLargeTileStairBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 86.5f;
	}
}