package net.mcreator.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class CeilingtilebuttonBlock extends ButtonBlock {
	public CeilingtilebuttonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, 20, properties.mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(25.5f, 33f).requiresCorrectToolForDrops());
	}
}