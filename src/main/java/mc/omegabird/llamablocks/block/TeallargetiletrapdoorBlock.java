package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class TeallargetiletrapdoorBlock extends TrapDoorBlock {
	public TeallargetiletrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}