package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class GreenbrickpreasureplateBlock extends PressurePlateBlock {
	public GreenbrickpreasureplateBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}