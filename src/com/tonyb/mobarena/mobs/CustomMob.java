package com.tonyb.mobarena.mobs;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CustomMob {

    private final EntityType type;
    private final double health;
    private final double damage;

    public CustomMob(EntityType type, double health, double damage) {
        this.type = type;
        this.health = health;
        this.damage = damage;
    }

    public EntityType getType() {
        return type;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }


    public LivingEntity spawn(Location location, JavaPlugin plugin) {
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, type);

        entity.setMaxHealth(health);
        entity.setHealth(health);
        onSpawn(entity, plugin);
        return entity;
    }

    public void onSpawn(LivingEntity entity, JavaPlugin plugin) {
        entity.setFireTicks(0);
    }
}