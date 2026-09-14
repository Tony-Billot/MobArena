package com.tonyb.mobarena.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoardManager {
	
	public void show(Player player, int wave, int enemies, int players) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("mobarena", "dummy");

        objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "MOB ARENA");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore("---------------").setScore(6);
        objective.getScore("Vague: " + wave).setScore(5);
        objective.getScore("Mobs: " + enemies).setScore(4);
        objective.getScore("Joueurs: " + players).setScore(3);
        objective.getScore("---------------").setScore(2);
        objective.getScore("Etat: Combat").setScore(1);

        player.setScoreboard(scoreboard);
    }
	
}
