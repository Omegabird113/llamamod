package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class IndustrialLargeTilePressurePlateBlock extends PressurePlateBlock {
	public IndustrialLargeTilePressurePlateBlock() {
		super(Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops().forceSolidOn(), BlockSetType.STONE);
	}
}