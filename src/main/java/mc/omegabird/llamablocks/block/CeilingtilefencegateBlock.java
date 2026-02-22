package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class CeilingtilefencegateBlock extends FenceGateBlock {
	public CeilingtilefencegateBlock() {
		super(WoodType.OAK, BlockBehaviour.Properties.of().mapColor(MapColor.ICE).sound(SoundType.METAL).strength(19f, 33f).requiresCorrectToolForDrops().forceSolidOn());
	}
}