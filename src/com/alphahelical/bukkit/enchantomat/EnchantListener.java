/**
 * 
 */
package com.alphahelical.bukkit.enchantomat;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author kbeckman
 *
 */
public class EnchantListener implements Listener {

	public EnchantListener(EnchantomatPlugin plugin) {
		
	}
	
	@EventHandler
	public void onPlayerBlockInteract (PlayerInteractEvent e) {
		if (e.isCancelled()) return;
		
		if(Enchanter.hasEnchanter(e.getClickedBlock())) {
			Player p = e.getPlayer();
			Block b = e.getClickedBlock();
			
			
		}
	}
	
	@EventHandler
	public void onInventoryClick (InventoryClickEvent e) {
		if (! e.isCancelled() && e.getInventory().getHolder() instanceof Enchanter) {
			Enchanter enchanter = (Enchanter) e.getInventory().getHolder();
			
		}
	}
	
}
