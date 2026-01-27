package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class GreenlargetiletrapdoorBlock extends TrapDoorBlock {
	public GreenlargetiletrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}