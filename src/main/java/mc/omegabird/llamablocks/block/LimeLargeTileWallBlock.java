package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class LimeLargeTileWallBlock extends WallBlock {
	public LimeLargeTileWallBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}