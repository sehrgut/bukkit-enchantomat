package com.alphahelical.bukkit.enchantomat;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchanterItem {

	private ItemStack item;
	private Integer cost;
	
	/**
	 * @return a defensive copy of the internal ItemStack
	 */
	public ItemStack getItem() {
		return item.clone();
	}

	private void setItem(ItemStack item) {
		this.item = item;
	}

	public int getCost() {
		return cost;
	}

	private void setCost(Integer cost) {
		this.cost = cost;
	}

	public EnchanterItem(ItemStack item, int cost) {
		this.setItem(item);
		this.setCost(cost);
	}
	
	public static EnchanterItem fromConfig(ConfigurationSection cfg) {
		String name = cfg.getString("item").toUpperCase();
		ItemStack item = new ItemStack(Material.getMaterial(name), 1);
		
		Integer cost = cfg.getInt("cost");
		
		ConfigurationSection enchants = cfg.getConfigurationSection("enchantments");
		
		for(String enchant : enchants.getKeys(false)) {
			int level = enchants.getInt(enchant);
			enchant = Config.resolveAlias(enchant).toUpperCase();
			Enchantment e = Enchantment.getByName(enchant);
			item.addEnchantment(e, level);
		}

		// TODO: put this in sgcore.itemhelper
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(String.format("Cost: %d", cost	));
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		return new EnchanterItem(item, cost);
	}

}
