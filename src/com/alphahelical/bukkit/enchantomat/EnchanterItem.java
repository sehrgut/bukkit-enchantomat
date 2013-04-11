package com.alphahelical.bukkit.enchantomat;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

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
		
		return new EnchanterItem(item, cost);
	}

}
