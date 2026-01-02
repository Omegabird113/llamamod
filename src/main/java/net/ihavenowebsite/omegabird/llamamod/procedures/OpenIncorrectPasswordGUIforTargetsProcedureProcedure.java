package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.ihavenowebsite.omegabird.llamamod.world.inventory.IncorrectPasswordGUIMenu;

import io.netty.buffer.Unpooled;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class OpenIncorrectPasswordGUIforTargetsProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				if (entityiterator instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("IncorrectPasswordGUI");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new IncorrectPasswordGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}