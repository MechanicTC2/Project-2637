package com.github.plugin;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;

public class Regg extends BukkitRunnable {
	Main plugin;
	Player player;
	Egg egg;
	Cuboids cuboids = new Cuboids();
	Listeners listeners;
	Score red_score, blue_score;
	boolean alreadyShot = false;
    public Regg(Main plugin, Player player, Egg egg, Listeners listeners) {
        this.plugin = plugin;
        this.player = player;
        this.egg = egg;
        this.listeners = listeners;
    }
	@Override
	public void run() {
		for (Block block : cuboids.score_rim) {
			if (Math.abs(egg.getLocation().getX() - block.getLocation().getX()) <= 1 || Math.abs(egg.getLocation().getZ() - block.getLocation().getZ()) <= 1 && !alreadyShot) {
				red_score = listeners.board.getObjective("frc").getScore("Red Alliance");
				red_score.setScore(red_score.getScore() + 2);
//				blue_score = listeners.board.getObjective("frc").getScore("Blue Alliance");
//				blue_score.setScore(blue_score.getScore() + 2);
				alreadyShot = !alreadyShot;
				for (Entity player: Bukkit.getOnlinePlayers()) {
					((Player) player).setScoreboard(listeners.board);
				}
			}
		}
		cancel();
	}
}
