/*
 * Handles events that are in Minecraft.
 * @author Nathan Kwok
 * @since 2023-02-17
 */

package com.github.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Listeners implements Listener {
	Cuboids cuboids = new Cuboids();
	Regg regg;
	Main main;
	Scoreboard board;
	public Listeners(Main plugin) {
		this.main = plugin;
	}
	@EventHandler
	public void slowEgg(ProjectileLaunchEvent e) {
		try {
			Egg egg = (Egg) e.getEntity();
			Player player = (Player) e.getEntity().getShooter();
			egg.setVelocity(player.getLocation().getDirection().multiply(0.8));
			egg.setInvulnerable(true);
			ScoreboardManager manager = Bukkit.getScoreboardManager();
            board = manager.getNewScoreboard();
            Objective objective = board.registerNewObjective("frc", "Scoreboard");        
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(ChatColor.GOLD + "FRC RAPID REACT");
            Score red = objective.getScore(ChatColor.RED + "Red Alliance");
            Score blue = objective.getScore(ChatColor.BLUE + "Blue Alliance");
			regg = new Regg(main, player, egg, this);
			regg.runTask(main);
		}
		catch (Exception exe) {
			System.out.println(exe);
		}
	}
	@EventHandler
	public void preventEgg(PlayerEggThrowEvent e) {
		e.setHatching(false);
	}
	@EventHandler
	public void preventBlockBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		if (cuboids.waiting_area.contains(block.getLocation())) {
			e.setCancelled(true);
		}
		else if (cuboids.game_field.contains(block.getLocation())) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void preventBlockPlace(BlockPlaceEvent e) {
		Block block = e.getBlock();
		if (cuboids.waiting_area.contains(block.getLocation())) {
			e.setCancelled(true);
		}
		else if (cuboids.game_field.contains(block.getLocation())) {
			e.setCancelled(true);
		}
	}
}