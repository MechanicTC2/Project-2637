/*
 * Handles events that are in Minecraft.
 * @author Nathan Kwok
 * @since 2023-02-17
 */

package com.github.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {
	/*
	private boolean move = true;
	@EventHandler
	public void creeperTime(BlockPlaceEvent event) {
		move = false;
		for (int i = 0; i < 10; i++) {
			Entity e = Bukkit.getWorld("world").spawnEntity(event.getPlayer().getLocation(), EntityType.CREEPER);
			event.getPlayer().addPassenger(e);
		}
		event.getPlayer().sendMessage("no building permit?");
	}
	@EventHandler
	public void constrictMovement(PlayerMoveEvent event) {
		if (move != true) {
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void allowMovement(PlayerRespawnEvent event) {
		move = true;
	}
	*/
	@EventHandler
	public void customItem(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Entity entity = Bukkit.getWorld("world").spawnEntity(player.getLocation().add(new Location(Bukkit.getWorld("world"), 0, 50, 0)), EntityType.BLAZE);
		Items items = new Items();
		player.getInventory().addItem(items.magicWand());
		player.teleport(entity.getLocation());
	}
	@EventHandler
	public void magic(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			ItemStack item = player.getInventory().getItemInMainHand();
			ItemMeta meta = item.getItemMeta();
			if (meta != null && meta.getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Magic Wand")) {
				Fireball fire = player.launchProjectile(Fireball.class);
				fire.setVelocity(player.getLocation().getDirection().multiply(1.5));
			}
		}
	}
}