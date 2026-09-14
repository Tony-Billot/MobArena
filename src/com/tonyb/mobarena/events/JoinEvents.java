package com.tonyb.mobarena.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.tonyb.mobarena.ui.ScoreBoardManager;

public class JoinEvents implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		e.setJoinMessage(null);
		player.sendMessage("Bienvenue sur MobArena");
		ScoreBoardManager scoreboard = new ScoreBoardManager();
		scoreboard.show(player, 0, 0, 0);
		
		return;
	}
	
}
