package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class CherrybrickpreasureplateBlock extends PressurePlateBlock {
	public CherrybrickpreasureplateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, properties.mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops().forceSolidOn());
	}
}