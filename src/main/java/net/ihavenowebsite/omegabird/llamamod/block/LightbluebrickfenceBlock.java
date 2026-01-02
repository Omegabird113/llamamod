package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class LightbluebrickfenceBlock extends FenceBlock {
	public LightbluebrickfenceBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}