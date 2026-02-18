package mc.omegabird.llamablocks.fluid;

import org.apache.logging.log4j.core.util.Source;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import mc.omegabird.llamablocks.init.LlamablocksModParticleTypes;
import mc.omegabird.llamablocks.init.LlamablocksModItems;
import mc.omegabird.llamablocks.init.LlamablocksModFluids;
import mc.omegabird.llamablocks.init.LlamablocksModFluidTypes;
import mc.omegabird.llamablocks.init.LlamablocksModBlocks;

public abstract class AcidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> LlamablocksModFluidTypes.ACID_TYPE.get(), () -> LlamablocksModFluids.ACID.get(), () -> LlamablocksModFluids.FLOWING_ACID.get())
			.explosionResistance(13f).tickRate(7).slopeFindDistance(5).bucket(() -> LlamablocksModItems.ACID_BUCKET.get()).block(() -> (LiquidBlock) LlamablocksModBlocks.ACID.get());

	private AcidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (LlamablocksModParticleTypes.ACIDPARTICLE.get());
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