/**
 * 
 */
package com.alphahelical.bukkit.enchantomat;

import java.util.HashMap;

import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author kbeckman
 *
 */
public class Enchanter {

	
	public Inventory getSalesInventory(ItemStack item) {
		return null;
	}

	private Block block;
	private Block getBlock() {
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
		if (! Util.isEnchanter(b))
			getEnchanters().put(b, new Enchanter(b));
		return getEnchanters().get(b);
	}
	
	
}
