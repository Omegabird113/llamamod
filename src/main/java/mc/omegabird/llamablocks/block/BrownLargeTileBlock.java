package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BrownLargeTileBlock extends Block {
	public BrownLargeTileBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}