package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedCyanBrickWallBlock extends WallBlock {
	public CrackedCyanBrickWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops().forceSolidOn());
	}
}