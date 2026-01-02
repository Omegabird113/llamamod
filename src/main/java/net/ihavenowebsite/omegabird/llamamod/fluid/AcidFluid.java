package net.ihavenowebsite.omegabird.llamamod.fluid;

import org.apache.logging.log4j.core.util.Source;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModParticleTypes;
import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModItems;
import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModFluids;
import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModFluidTypes;
import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModBlocks;

public abstract class AcidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> LlamamodModFluidTypes.ACID_TYPE.get(), () -> LlamamodModFluids.ACID.get(), () -> LlamamodModFluids.FLOWING_ACID.get()).explosionResistance(13f)
			.tickRate(7).slopeFindDistance(5).bucket(() -> LlamamodModItems.ACID_BUCKET.get()).block(() -> (LiquidBlock) LlamamodModBlocks.ACID.get());

	private AcidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (LlamamodModParticleTypes.ACIDPARTICLE.get());
	}

	public static class Source extends AcidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AcidFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}