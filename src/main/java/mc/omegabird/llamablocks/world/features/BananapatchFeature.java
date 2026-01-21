package mc.omegabird.llamablocks.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import mc.omegabird.llamablocks.procedures.BananapatchAdditionalGenerationConditionProcedure;

public class BananapatchFeature extends RandomPatchFeature {
	public BananapatchFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!BananapatchAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}