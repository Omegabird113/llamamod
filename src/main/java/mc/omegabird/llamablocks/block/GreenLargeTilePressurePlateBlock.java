package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class GreenLargeTilePressurePlateBlock extends PressurePlateBlock {
	public GreenLargeTilePressurePlateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}