package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class WhitebrickpreasureplateBlock extends PressurePlateBlock {
	public WhitebrickpreasureplateBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops().forceSolidOn());
	}
}