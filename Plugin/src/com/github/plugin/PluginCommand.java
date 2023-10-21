/*
 * Handles input commands that are inputed from Minecraft.
 * @param sender the Player that is sending the command.
 * @param args the arguments that are sent via chat command. 
 * @author Nathan Kwok
 * @since 2023-02-17
 */

package com.github.plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PluginCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		/*
		 * if (args[0].equalsIgnoreCase("give")) { if (args[1].equalsIgnoreCase("ns")) {
		 * player.getInventory().addItem(new ItemStack(Material.NETHERITE_SWORD)); Items
		 * e = new Items(); player.getInventory().addItem(e.magicWand()); } if
		 * (args[1].equalsIgnoreCase("ar")) { player.setArrowsInBody(999); } } if
		 * (args[0].equalsIgnoreCase("sit")) { for (Entity e :
		 * player.getNearbyEntities(100, 100, 100)) { if (e.getType() !=
		 * EntityType.SKELETON && e.getType() != EntityType.CREEPER) {
		 * player.addPassenger(e); } } }
		 */
		player.setMaxHealth(100);
		player.setHealth(100);
		
		
		
		
		
		
		
		
		return false;
	}

}
