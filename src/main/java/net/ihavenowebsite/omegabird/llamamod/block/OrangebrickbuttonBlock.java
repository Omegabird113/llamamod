package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class OrangebrickbuttonBlock extends ButtonBlock {
	public OrangebrickbuttonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, 20, properties.mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL).strength(2f, 6f));
	}
}