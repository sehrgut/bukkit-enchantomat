/**
 * 
 */
package com.alphahelical.bukkit.enchantomat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 * @author kbeckman
 *
 */
public class Enchanter implements InventoryHolder {

	
	public Inventory getSalesInventory(ItemStack item) {
		return null;
	}

	private Block block;
	public Block getBlock() {
		return this.block;
	}
	private void setBlock(Block block) {
		this.block = block;
	}
	
	
	private Enchanter(Block b) {
		this.setBlock(b);
	}
	
	private static HashMap<Block, Enchanter> enchanters;
	
	private static HashMap<Block, Enchanter> getEnchanters() {
		if (enchanters == null) enchanters = new HashMap<Block, Enchanter>();
		return enchanters;
	}
	
	public static Enchanter getEnchanter(Block b) {
		if (! hasEnchanter(b))
			getEnchanters().put(b, new Enchanter(b));
		return getEnchanters().get(b);
	}
	
	public static boolean hasEnchanter(Block b) {
		return getEnchanters().containsKey(b);
	}
	
	public boolean canEnchant(Material mat) {
		return (Config.getItems().get(mat) != null);
	}
	
	public void showInventory(Player p) {
		ItemStack item = p.getItemInHand();
		Map<ItemStack, Integer> catalog = Config.getItems().get(item.getType());
		
		Collection<ItemStack> items = com.alphahelical.collections.Collections.pick(
				catalog.keySet(), this.getInventory().getSize());

		this.getInventory().clear();
		this.getInventory().addItem(items.toArray(new ItemStack[items.size()]));	
	}
	
	private Inventory inventory;
	@Override
	public Inventory getInventory() {
		if (this.inventory == null)
			this.inventory = Bukkit.getServer().createInventory(this, 9, "Enchant-O-Mat");
		return this.inventory;
	}
		
}
