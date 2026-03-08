package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class IndustrialLargeTileFenceGateBlock extends FenceGateBlock {
	public IndustrialLargeTileFenceGateBlock() {
		super(WoodType.OAK, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops().forceSolidOn());
	}
}