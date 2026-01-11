package mc.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CeilingtileslabBlock extends SlabBlock {
	public CeilingtileslabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(19f, 33f).requiresCorrectToolForDrops());
	}
}