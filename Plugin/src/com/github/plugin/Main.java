/*
 * Handles server startup.
 * @author Nathan Kwok
 * @since 2023-02-17
 */
package com.github.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		//Register Listener and PlayerCommand class
		System.out.println("Your plugin is now enabled.");
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getCommand("2637").setExecutor(new PluginCommand(this));
	}
	
	@Override
	public void onDisable() {
		System.out.println("Your plugin is now disabled.");
	}
}
