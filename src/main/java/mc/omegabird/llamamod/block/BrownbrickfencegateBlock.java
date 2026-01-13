package mc.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class BrownbrickfencegateBlock extends FenceGateBlock {
	public BrownbrickfencegateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(2f, 6f).instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
	}
}