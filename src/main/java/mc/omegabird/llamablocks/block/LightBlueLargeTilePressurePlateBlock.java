package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class LightBlueLargeTilePressurePlateBlock extends PressurePlateBlock {
	public LightBlueLargeTilePressurePlateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}