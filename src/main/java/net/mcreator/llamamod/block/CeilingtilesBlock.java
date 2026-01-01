package net.mcreator.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CeilingtilesBlock extends Block {
	public CeilingtilesBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(19f, 33f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}