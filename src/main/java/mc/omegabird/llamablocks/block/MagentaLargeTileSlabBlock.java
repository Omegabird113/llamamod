package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class MagentaLargeTileSlabBlock extends SlabBlock {
	public MagentaLargeTileSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}