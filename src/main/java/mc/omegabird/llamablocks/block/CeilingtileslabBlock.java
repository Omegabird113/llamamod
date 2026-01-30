package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CeilingtileslabBlock extends SlabBlock {
	public CeilingtileslabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).sound(SoundType.METAL).strength(19f, 33f).requiresCorrectToolForDrops());
	}
}