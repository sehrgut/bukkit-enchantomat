package com.alphahelical.bukkit.enchantomat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

public class Config {
	private Config () {}
	
	private static Plugin plugin;
	protected static Plugin getPlugin() {
		if (plugin == null)
			plugin = Bukkit.getServer().getPluginManager().getPlugin("Enchantomat");
		return plugin;
	}


	public static String resolveAlias (String alias) {
		return getPlugin().getConfig().getConfigurationSection("aliases").getString(alias, alias);
	}
	
	public static Map<Material, List<EnchanterItem>> getItems() {
		
		List<?> items = getPlugin().getConfig().getList("items");
		
		Map<Material, List<EnchanterItem>> out = new HashMap<Material, List<EnchanterItem>>();
		
		for(Object i : items) {
			if (i instanceof ConfigurationSection) {
				EnchanterItem item = EnchanterItem.fromConfig((ConfigurationSection) i);
				
				if (! out.containsKey(item.getItem().getType()))
					out.put(item.getItem().getType(), new ArrayList<EnchanterItem>());
				
				out.get(item.getItem().getType()).add(item);
			}
		}
		
		return out;
	}
		
	
	
}
