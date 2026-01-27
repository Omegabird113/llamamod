package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class GreenLargeTileFenceGateBlock extends FenceGateBlock {
	public GreenLargeTileFenceGateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}