package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class PinkLargeTileFenceGateBlock extends FenceGateBlock {
	public PinkLargeTileFenceGateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}