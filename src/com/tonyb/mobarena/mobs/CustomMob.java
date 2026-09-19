package com.tonyb.mobarena.mobs;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CustomMob {

    private final EntityType type;

    public CustomMob(EntityType type) {
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }



    public LivingEntity spawn(Location location, JavaPlugin plugin) {
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, type);

        onSpawn(entity, plugin);
        return entity;
    }

    public void onSpawn(LivingEntity entity, JavaPlugin plugin) {
        entity.setFireTicks(0);
    }
}