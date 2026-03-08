package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class CrackedYellowBrickFenceBlock extends FenceBlock {
	public CrackedYellowBrickFenceBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}