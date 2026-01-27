package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class LightGrayLargeTileStairBlock extends StairBlock {
	public LightGrayLargeTileStairBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 16f;
	}
}