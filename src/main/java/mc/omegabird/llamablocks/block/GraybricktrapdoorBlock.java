package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class GraybricktrapdoorBlock extends TrapDoorBlock {
	public GraybricktrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}
}