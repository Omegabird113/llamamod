package net.mcreator.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class CeilingtilepressureplateBlock extends PressurePlateBlock {
	public CeilingtilepressureplateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(25.5f, 33f).requiresCorrectToolForDrops().forceSolidOn());
	}
}