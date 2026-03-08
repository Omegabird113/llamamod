package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class OrangeLargeTileSlabBlock extends SlabBlock {
	public OrangeLargeTileSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}