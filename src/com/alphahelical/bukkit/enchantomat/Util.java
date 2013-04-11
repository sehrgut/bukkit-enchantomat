/**
 * 
 */
package com.alphahelical.bukkit.enchantomat;

import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * @author kbeckman
 *
 */
public class Util {

	private Util() {}
	
	public static boolean isEnchanter(Block b) {
		return b.getType().equals(Material.ENCHANTMENT_TABLE);
	}
	
}
