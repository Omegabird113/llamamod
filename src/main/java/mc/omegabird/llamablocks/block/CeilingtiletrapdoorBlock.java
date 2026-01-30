package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class CeilingtiletrapdoorBlock extends TrapDoorBlock {
	public CeilingtiletrapdoorBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.ICE).sound(SoundType.METAL).strength(25.5f, 33f).requiresCorrectToolForDrops());
	}
}