package com.tonyb.mobarena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import com.tonyb.mobarena.commands.SpawnMobCommand;
import com.tonyb.mobarena.commands.StartArena;
import com.tonyb.mobarena.events.JoinEvents;
import com.tonyb.mobarena.events.MobEvents;
import com.tonyb.mobarena.gamemanagers.WaveManager;


public class MobArena extends JavaPlugin {
	
	private WaveManager waveManager;

	
	@Override
	public void onEnable() {
		System.out.println("Started MobArena");
		
		// Game Managers
		waveManager = new WaveManager(this, new Location(Bukkit.getWorld("world"), 0, 100, 0));
		
		getServer().getPluginManager().registerEvents(new JoinEvents(), this);
		getServer().getPluginManager().registerEvents(new MobEvents(), this);
		getCommand("spawnmob").setExecutor(new SpawnMobCommand(this));
		getCommand("startarena").setExecutor(new StartArena(this));

		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public void startArena(Location location) {
	    waveManager = new WaveManager(this, location);
	    waveManager.start();
	}

}
