package net.ihavenowebsite.omegabird.llamamod.fluid.types;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class AcidFluidType extends FluidType {
	public AcidFluidType() {
		super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(-0.00091D).temperature(906).canConvertToSource(true).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.bucket.empty"))).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}
}