package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class LightBlueLargeTileButtonBlock extends ButtonBlock {
	public LightBlueLargeTileButtonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, 20, properties.mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}