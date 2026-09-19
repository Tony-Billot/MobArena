package com.tonyb.mobarena.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;

public class MobEvents implements Listener {
	
	@EventHandler
	public void onEntityCombust(EntityCombustEvent event) {
	    Entity entity = event.getEntity();

	    if (!(entity instanceof Zombie) && !(entity instanceof Skeleton)) {
	        return;
	    }

	    if (event instanceof EntityCombustByBlockEvent || event instanceof EntityCombustByEntityEvent) {
	        return;
	    }

	    event.setCancelled(true);
	}

}
