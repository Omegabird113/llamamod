package net.mcreator.llamamod.fluid;

import org.apache.logging.log4j.core.util.Source;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.llamamod.init.LlamaModModParticleTypes;
import net.mcreator.llamamod.init.LlamaModModItems;
import net.mcreator.llamamod.init.LlamaModModFluids;
import net.mcreator.llamamod.init.LlamaModModFluidTypes;
import net.mcreator.llamamod.init.LlamaModModBlocks;

public abstract class AcidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> LlamaModModFluidTypes.ACID_TYPE.get(), () -> LlamaModModFluids.ACID.get(), () -> LlamaModModFluids.FLOWING_ACID.get()).explosionResistance(13f)
			.tickRate(7).slopeFindDistance(5).bucket(() -> LlamaModModItems.ACID_BUCKET.get()).block(() -> (LiquidBlock) LlamaModModBlocks.ACID.get());

	private AcidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (LlamaModModParticleTypes.ACIDPARTICLE.get());
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