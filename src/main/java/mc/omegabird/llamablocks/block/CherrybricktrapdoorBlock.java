package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class CherrybricktrapdoorBlock extends TrapDoorBlock {
	public CherrybricktrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, properties.mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops());
	}
}