package mc.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class OrangebrickwallBlock extends WallBlock {
	public OrangebrickwallBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}