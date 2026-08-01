/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.core.registries.BuiltInRegistries;

import io.github.omegabird113.llamablocks.LlamamodMod;

@EventBusSubscriber
public class LlamamodModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, LlamamodMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> ACID_DAMAGE_PROTECTION = REGISTRY.register("acid_damage_protection", () -> new RangedAttribute("attribute.llamamod.acid_damage_protection", 0d, 0d, 1d).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, ACID_DAMAGE_PROTECTION));
	}
}