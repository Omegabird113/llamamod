package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedMagentaLargeTileWallBlock extends WallBlock {
	public CrackedMagentaLargeTileWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}