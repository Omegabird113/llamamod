package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class TeallargetilefencegateBlock extends FenceGateBlock {
	public TeallargetilefencegateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}