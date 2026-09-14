package com.tonyb.mobarena;

import org.bukkit.plugin.java.JavaPlugin;
import com.tonyb.mobarena.events.JoinEvents;
public class MobArena extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Started MobArena");
		
		getServer().getPluginManager().registerEvents(new JoinEvents(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

}
