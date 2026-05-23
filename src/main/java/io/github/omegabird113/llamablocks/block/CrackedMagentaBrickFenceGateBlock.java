package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class CrackedMagentaBrickFenceGateBlock extends FenceGateBlock {
	public CrackedMagentaBrickFenceGateBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn(), WoodType.OAK);
	}
}