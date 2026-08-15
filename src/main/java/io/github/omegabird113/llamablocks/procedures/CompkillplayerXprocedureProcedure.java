package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.ArrayList;

import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class CompkillplayerXprocedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity player_to_msg = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (((entityiterator.getDisplayName().getString()).toUpperCase())
					.equals((((entity instanceof Player _entity1 && _entity1.containerMenu instanceof LlamamodModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "player_name", "") : "").toUpperCase()).strip())) {
				player_to_msg = entityiterator;
			}
		}
		if (player_to_msg == null) {
			player_to_msg = entity;
			if (player_to_msg instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("block.llamamod.computer.playernamenotfounderror").getString())), false);
		} else {
			if (player_to_msg instanceof Player _player) {
				_player.getAbilities().invulnerable = false;
				_player.onUpdateAbilities();
			}
			player_to_msg.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("llamamod:computer_player_management_damage"))), entity),
					1000000);
		}
	}
}