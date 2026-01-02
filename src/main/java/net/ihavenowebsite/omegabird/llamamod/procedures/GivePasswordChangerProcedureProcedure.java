package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GivePasswordChangerProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				if (entityiterator instanceof Player _player) {
					ItemStack _setstack = new ItemStack(LlamamodModItems.PASSWORD_CHANGER.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}