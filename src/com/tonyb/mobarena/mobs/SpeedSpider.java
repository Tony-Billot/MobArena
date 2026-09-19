package com.tonyb.mobarena.mobs;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Spider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedSpider extends CustomMob {

    public SpeedSpider() {
        super(EntityType.SPIDER);
    }

    @Override
    public void onSpawn(LivingEntity entity, JavaPlugin plugin) {

        Spider spider = (Spider) entity;

        spider.setCustomName("§cAraignée Frénétique");
        spider.setCustomNameVisible(true);

        spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));

    }

}