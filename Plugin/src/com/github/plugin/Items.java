package com.github.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Items {
	public ItemStack magicWand() {
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Wand");
		lore.add(ChatColor.ITALIC + "The ultimate magic wand");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
}
