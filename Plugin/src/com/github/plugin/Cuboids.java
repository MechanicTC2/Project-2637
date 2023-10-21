package com.github.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Cuboids {
	Cuboid waiting_area = new Cuboid(new Location(Bukkit.getWorld("world"), 36.0, 67.0, -7.0), new Location(Bukkit.getWorld("world"), 30.0, 72.0, -13.0));
	Cuboid score_rim = new Cuboid(new Location(Bukkit.getWorld("world"), 31.0, 75.0, 17.0), new Location(Bukkit.getWorld("world"), 34.0, 75.0, 14.0));
	Cuboid game_field = new Cuboid(new Location(Bukkit.getWorld("world"), 60.0, 67.0, 1.0), new Location(Bukkit.getWorld("world"), 5.0, 76.0, 30.0));
}
