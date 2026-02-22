package mc.omegabird.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedBrownBrickWallBlock extends WallBlock {
	public CrackedBrownBrickWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(2f, 6f).instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
	}
}