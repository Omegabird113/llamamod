package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class TealLargeTileStairBlock extends StairBlock {
	public TealLargeTileStairBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 16f;
	}
}