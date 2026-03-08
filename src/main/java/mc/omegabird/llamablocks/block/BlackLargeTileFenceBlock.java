package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class BlackLargeTileFenceBlock extends FenceBlock {
	public BlackLargeTileFenceBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}