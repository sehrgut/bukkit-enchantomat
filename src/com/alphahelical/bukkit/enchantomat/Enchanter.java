/**
 * 
 */
package com.alphahelical.bukkit.enchantomat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 * @author kbeckman
 *
 */
public class Enchanter {


	private List<Inventory> getLinkedInventories() {
		List<BlockFace> searchFaces = Arrays.asList(BlockFace.DOWN, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST);
		BlockFace inventoryFace = null;
		
		for (BlockFace face : searchFaces) {
			if(this.getBlock().getRelative(face).getState() instanceof InventoryHolder) {
				inventoryFace = face;
				break;
			}
		}
		
		List<Inventory> inventories = new ArrayList<Inventory> ();
		
		Block cur = this.getBlock();
		while(cur == this.getBlock() || cur.getState() instanceof InventoryHolder) {
			// TODO: finish block search. this is enough of a pain it should be general-purpose
		}
		
		return null;
	}
	
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
		if (! hasEnchanter(b))
			getEnchanters().put(b, new Enchanter(b));
		return getEnchanters().get(b);
	}
	
	public static boolean hasEnchanter(Block b) {
		return getEnchanters().containsKey(b);
	}
	
	
}
