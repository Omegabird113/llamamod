package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CrackedWhiteBrickSlabBlock extends SlabBlock {
	public CrackedWhiteBrickSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.QUARTZ).sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}
}