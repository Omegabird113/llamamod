package mc.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class TilepressureplateBlock extends PressurePlateBlock {
	public TilepressureplateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.COLOR_GRAY).sound(SoundType.METAL).strength(7f, 23.65f).requiresCorrectToolForDrops().forceSolidOn());
	}
}