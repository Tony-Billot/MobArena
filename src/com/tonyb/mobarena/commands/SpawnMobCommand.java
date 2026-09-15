package com.tonyb.mobarena.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.tonyb.mobarena.MobArena;
import com.tonyb.mobarena.mobs.CustomMob;
import com.tonyb.mobarena.mobs.MobInit;

public class SpawnMobCommand implements CommandExecutor {

    private final MobArena plugin;

    public SpawnMobCommand(MobArena plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande doit être exécutée par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        CustomMob mob = MobInit.LIGHTNING_ZOMBIE.getMob();

        LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), mob.getType());

        entity.setMaxHealth(mob.getHealth());
        entity.setHealth(mob.getHealth());

        mob.onSpawn(entity, plugin);

        player.sendMessage("Mob apparu : " + mob.getClass().getSimpleName());

        return true;
    }

}