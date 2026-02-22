package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class BluebrickslabBlock extends SlabBlock {
	public BluebrickslabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.METAL).strength(2f, 6f));
	}
}