package com.tonyb.mobarena.gamemanagers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.tonyb.mobarena.mobs.CustomMob;
import com.tonyb.mobarena.mobs.LightningZombie;
import com.tonyb.mobarena.mobs.SpeedSpider;
import com.tonyb.mobarena.ui.ScoreBoardManager;

public class WaveManager {

    private final JavaPlugin plugin;
    private final ScoreBoardManager scoreboardManager;
    private final Location spawnLocation;

    private int wave = 0;
    private boolean startingNextWave = false;
    private final List<LivingEntity> enemies = new ArrayList<LivingEntity>();

    public WaveManager(JavaPlugin plugin, Location spawnLocation) {
        this.plugin = plugin;
        this.spawnLocation = spawnLocation;
        this.scoreboardManager = new ScoreBoardManager();
    }

    public void start() {
        startNextWave();

        new BukkitRunnable() {
            @Override
            public void run() {
                update();
            }
        }.runTaskTimer(plugin, 20L, 20L);
    }

    private void startNextWave() {

        wave++;
        startingNextWave = false;

        int mobAmount = 5 + (wave - 1) * 2;
        spawnMobs(spawnLocation, mobAmount);
        updateScoreboard();

    }

    private void spawnMobs(Location location, int amount) {

        for (int i = 0; i < amount; i++) {

            CustomMob customMob;

            if (i % 2 == 0) {
                customMob = new LightningZombie();
            } else {
                customMob = new SpeedSpider();
            }

            LivingEntity entity = customMob.spawn(location, plugin);

            enemies.add(entity);
        }
    }

    public void update() {

        for (int i = enemies.size() - 1; i >= 0; i--) {

            LivingEntity entity = enemies.get(i);

            if (entity == null || entity.isDead()) {
                enemies.remove(i);
            }
        }

        updateScoreboard();

        if (enemies.isEmpty() && !startingNextWave) {

            startingNextWave = true;

            new BukkitRunnable() {
                @Override
                public void run() {
                    startNextWave();
                }
            }.runTaskLater(plugin, 100L);
        }
    }

    private void updateScoreboard() {

        int alive = enemies.size();
        int players = plugin.getServer().getOnlinePlayers().size();

        for (org.bukkit.entity.Player player : plugin.getServer().getOnlinePlayers()) {
            scoreboardManager.show(player, wave, alive, players);
        }
    }

    public int getWave() {
        return wave;
    }

    public List<LivingEntity> getEnemies() {
        return enemies;
    }

}