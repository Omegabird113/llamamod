package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class LightGrayLargeTileButtonBlock extends ButtonBlock {
	public LightGrayLargeTileButtonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, 20, properties.mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}