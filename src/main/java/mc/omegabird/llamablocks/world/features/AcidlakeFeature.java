package mc.omegabird.llamablocks.world.features;

import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import mc.omegabird.llamablocks.procedures.AcidLakeGenerationConditionProcedureProcedure;

public class AcidlakeFeature extends LakeFeature {
	public AcidlakeFeature() {
		super(LakeFeature.Configuration.CODEC);
	}

	public boolean place(FeaturePlaceContext<LakeFeature.Configuration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!AcidLakeGenerationConditionProcedureProcedure.execute())
			return false;
		return super.place(context);
	}
}