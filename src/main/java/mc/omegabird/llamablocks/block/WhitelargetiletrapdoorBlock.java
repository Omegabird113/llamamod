package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class WhitelargetiletrapdoorBlock extends TrapDoorBlock {
	public WhitelargetiletrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}