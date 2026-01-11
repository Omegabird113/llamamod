package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class ReturnPlayerListProcedureProcedure {
	public static String execute(LevelAccessor world) {
		String playerList = "";
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((playerList).equals("")) {
				playerList = entityiterator.getDisplayName().getString();
			} else {
				playerList = playerList + ", " + entityiterator.getDisplayName().getString();
			}
		}
		return playerList;
	}
}