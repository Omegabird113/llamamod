package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class CrackedLimeLargeTileButtonBlock extends ButtonBlock {
	public CrackedLimeLargeTileButtonBlock() {
		super(BlockSetType.STONE, 20, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}