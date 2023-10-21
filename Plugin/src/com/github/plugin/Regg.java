package com.github.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Regg extends BukkitRunnable {
	Main plugin;
	Player player;
	Egg egg;
	Cuboids cuboids = new Cuboids();
    public Regg(Main plugin, Player player, Egg egg) {
        this.plugin = plugin;
        this.player = player;
        this.egg = egg;
    }
	@Override
	public void run() {
		Bukkit.getWorld("world").playSound(player, Sound.AMBIENT_CAVE, 100, 100);
		player.sendMessage("asdfasdf");
		for (Block block : cuboids.score_rim) {
			if (block.getLocation().equals(((Entity) egg).getLocation())) {
				Bukkit.getWorld("world").playSound(player, Sound.AMBIENT_CAVE, 100, 100);
				cancel();
			}
		}
	}
}
