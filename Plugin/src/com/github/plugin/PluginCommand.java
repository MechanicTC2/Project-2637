/*
 * Handles input commands that are inputed from Minecraft.
 * @param sender the Player that is sending the command.
 * @param args the arguments that are sent via chat command. 
 * @author Nathan Kwok
 * @since 2023-02-17
 */

package com.github.plugin;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PluginCommand implements CommandExecutor {
	Teleop teleop;
	Main main;
	public PluginCommand(Main plugin) {
		this.main = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		try {
			Player player = (Player) sender;
			teleop = new Teleop(this.main, player);
			if (args[0].equalsIgnoreCase("frc")) {
				if (args[1].equalsIgnoreCase("start")) {
					teleop = new Teleop(this.main, player);
					Bukkit.broadcastMessage(ChatColor.GOLD + "Drivers, behind the line!");
					TimeUnit.SECONDS.sleep(1);
					Bukkit.broadcastMessage(ChatColor.GOLD + "3,");
					TimeUnit.SECONDS.sleep(1);
					Bukkit.broadcastMessage(ChatColor.GOLD + "2,");
					TimeUnit.SECONDS.sleep(1);
					Bukkit.broadcastMessage(ChatColor.GOLD + "1,");
					TimeUnit.SECONDS.sleep(1);
					Bukkit.broadcastMessage(ChatColor.GOLD + "GO!");
					player.teleport(new Location(Bukkit.getWorld("world"), 23.0, 68.0, 6.0));
					teleop.runTaskLater((Plugin) this.main, (20 * 135L));
				}
			}	
		}
		catch (Exception exe) {
			exe.printStackTrace();
		}
		return false;
	}

}
