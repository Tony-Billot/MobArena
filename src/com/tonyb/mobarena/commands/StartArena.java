package com.tonyb.mobarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.tonyb.mobarena.MobArena;

public class StartArena implements CommandExecutor {
	
    private final MobArena plugin;
    
    public StartArena(MobArena plugin) {
        this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        plugin.startArena(player.getLocation());
        player.sendMessage("§aMobArena lancée !");
        
        
        PlayerInventory inventory = player.getInventory();
        inventory.clear();

        inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));

        inventory.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inventory.setItem(1, new ItemStack(Material.GOLDEN_APPLE, 5));
        inventory.setItem(2, new ItemStack(Material.COOKED_BEEF, 32));
        
		return true;
	}

}
