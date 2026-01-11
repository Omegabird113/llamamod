package mc.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class IndustrialLargeTileBlock extends Block {
	public IndustrialLargeTileBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}