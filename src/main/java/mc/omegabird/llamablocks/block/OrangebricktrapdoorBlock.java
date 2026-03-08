package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class OrangebricktrapdoorBlock extends TrapDoorBlock {
	public OrangebricktrapdoorBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL).strength(2f, 6f));
	}
}