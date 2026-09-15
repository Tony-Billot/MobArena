package com.tonyb.mobarena;

import org.bukkit.plugin.java.JavaPlugin;

import com.tonyb.mobarena.commands.SpawnMobCommand;
import com.tonyb.mobarena.events.JoinEvents;
import com.tonyb.mobarena.events.MobEvents;
public class MobArena extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Started MobArena");
		
		getServer().getPluginManager().registerEvents(new JoinEvents(), this);
		getServer().getPluginManager().registerEvents(new MobEvents(), this);
		getCommand("spawnmob").setExecutor(new SpawnMobCommand(this));
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

}
