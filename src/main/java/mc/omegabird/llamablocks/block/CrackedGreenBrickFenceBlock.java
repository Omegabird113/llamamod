package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class CrackedGreenBrickFenceBlock extends FenceBlock {
	public CrackedGreenBrickFenceBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}