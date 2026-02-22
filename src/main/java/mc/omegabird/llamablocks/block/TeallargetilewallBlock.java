package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class TeallargetilewallBlock extends WallBlock {
	public TeallargetilewallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}