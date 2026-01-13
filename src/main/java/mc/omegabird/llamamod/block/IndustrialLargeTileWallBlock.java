package mc.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class IndustrialLargeTileWallBlock extends WallBlock {
	public IndustrialLargeTileWallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops().forceSolidOn());
	}
}