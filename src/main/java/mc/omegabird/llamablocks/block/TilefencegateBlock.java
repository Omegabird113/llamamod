package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class TilefencegateBlock extends FenceGateBlock {
	public TilefencegateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.mapColor(MapColor.COLOR_GRAY).sound(SoundType.METAL).strength(7f, 23.65f).requiresCorrectToolForDrops().forceSolidOn());
	}
}