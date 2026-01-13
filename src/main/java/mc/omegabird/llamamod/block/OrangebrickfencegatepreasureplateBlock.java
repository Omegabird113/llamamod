package mc.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class OrangebrickfencegatepreasureplateBlock extends PressurePlateBlock {
	public OrangebrickfencegatepreasureplateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}