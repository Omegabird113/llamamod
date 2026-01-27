package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class BlueLargeTileFenceBlock extends FenceBlock {
	public BlueLargeTileFenceBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BLUE).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}