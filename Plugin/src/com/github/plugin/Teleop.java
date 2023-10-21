package com.github.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Teleop extends BukkitRunnable {
	Main plugin;
	Player player;
	Cuboids cuboids = new Cuboids();
	int count = 0;
    public Teleop(Main plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }
	@Override
	public void run() {
		player.sendMessage("Time's up!");
		if (cuboids.game_field.contains(player.getLocation())) {
			player.teleport(new Location(Bukkit.getWorld("world"), -33.0, 68.0, -10.0));
		}
		//cancel();
	}
}
