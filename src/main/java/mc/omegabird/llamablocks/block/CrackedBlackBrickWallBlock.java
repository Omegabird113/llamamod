package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedBlackBrickWallBlock extends WallBlock {
	public CrackedBlackBrickWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}