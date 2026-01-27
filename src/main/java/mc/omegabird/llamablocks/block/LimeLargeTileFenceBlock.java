package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class LimeLargeTileFenceBlock extends FenceBlock {
	public LimeLargeTileFenceBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}