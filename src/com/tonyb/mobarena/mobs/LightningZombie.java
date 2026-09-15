package com.tonyb.mobarena.mobs;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class LightningZombie extends CustomMob {

    public LightningZombie() {
        super(EntityType.ZOMBIE, 20, 3);
    }

    @Override
    public void onSpawn(LivingEntity entity, JavaPlugin plugin) {
        Zombie zombie = (Zombie) entity;

        new BukkitRunnable() {
            @Override
            public void run() {
                if (zombie.isDead()) {
                    cancel();
                    return;
                }

                Location location = zombie.getLocation();
                location.getWorld().strikeLightningEffect(location);
            }
        }.runTaskTimer(plugin, 0L, 100L);
    }

}