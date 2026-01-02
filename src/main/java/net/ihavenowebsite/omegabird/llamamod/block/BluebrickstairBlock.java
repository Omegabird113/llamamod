package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class BluebrickstairBlock extends StairBlock {
	public BluebrickstairBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.mapColor(MapColor.COLOR_BLUE).sound(SoundType.METAL).strength(2f, 6f));
	}

	@Override
	public float getExplosionResistance() {
		return 6f;
	}
}