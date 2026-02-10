package mc.omegabird.llamablocks.world.features;

import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class AcidlakeFeature extends LakeFeature {
	public AcidlakeFeature() {
		super(LakeFeature.Configuration.CODEC);
	}

	public boolean place(FeaturePlaceContext<LakeFeature.Configuration> context) {
		return super.place(context);
	}
}