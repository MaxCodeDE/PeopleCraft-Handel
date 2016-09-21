package me.MaxCode.PeopleCraftHandel;

import java.io.File;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VerkaufManager {

	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	public String menuName = str + "Verkaufen";
	
	
	
	public Economy econ;
	public PeopleCraftHandel pch;
	
	@SuppressWarnings("static-access")
	public VerkaufManager(PeopleCraftHandel class1) {
		econ = pch.economy;
		pch = class1;
	}
	
	
	
	
	
	public void openVerkaufMenu(Player p) {
		
		Inventory inv = Bukkit.createInventory(p, 36, menuName);
		
		ItemStack fertig = new ItemStack(Material.IRON_DOOR);
		ItemMeta fertigm = fertig.getItemMeta();
		fertigm.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► "  + "Items verkaufen");
		fertig.setItemMeta(fertigm);
		inv.setItem(35, fertig);
		
		
		p.openInventory(inv);
	}
	

	
	
	
	

	public void buyItem(Inventory inv, Player p) {
		
		
		for (ItemStack item : inv.getContents()) {
			
			if (item != null) {
				
			if (this.fileContainsItem(item)) {
				int VerkaufPreis = this.getVerkaufPreis(item);
				int ItemAnzahl = this.getItemAnzahl(inv, item);
				VerkaufPreis = VerkaufPreis * ItemAnzahl;
				
				if (econ != null) {
					
				inv.remove(item);
				econ.depositPlayer(p, VerkaufPreis);
				
				p.sendMessage(str + "Du hast '" + item.getType().toString() + "' fuer " + VerkaufPreis + " Bux verkauft!");
				
				EffectManager em = new EffectManager();
				em.playEffectToPlayer(p);
				
				} else{
					p.sendMessage(str + "Ein Fehler ist aufgetreten! econ == null");
				}
				
				
			} else {
				if (!item.getType().equals(Material.IRON_DOOR)) {
				p.sendMessage(str + "Das Item '" + item.getType().toString() + "' kann nicht verkauft werden!");
				}
			}
			}
		}
		
		
	}
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public int getVerkaufPreis(ItemStack item) {
		
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Items.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int ItemVerkaufPreis = 0;
				
		for (String type : cfg.getConfigurationSection("Items.").getKeys(false)) {
			
			for (String id : cfg.getConfigurationSection("Items." + type).getKeys(false)) {
			
			String Item = cfg.getString("Items." + type + "." + id + ".Material");
			int ItemShort = cfg.getInt("Items." + type + "." + id + ".Short");
			
			
			Material materialcfg = Material.getMaterial(Item);
			ItemStack itemcfg = new ItemStack(materialcfg, 1, (short) ItemShort);
			
			if (materialcfg.equals(item.getType()) && itemcfg.getData().getData() == item.getData().getData()) {
				
				ItemVerkaufPreis = cfg.getInt("Items." + type + "." + id + ".VerKaufPreis");
				
			}
			
			
			}
			
		}
			
			
			return ItemVerkaufPreis;

}
	
	public boolean fileContainsItem(ItemStack items) {
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Items.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		boolean containsItem = false;
				
		for (String type : cfg.getConfigurationSection("Items.").getKeys(false)) {
			
			
			for (String id : cfg.getConfigurationSection("Items." + type).getKeys(false)) {
			
			
				String Item = cfg.getString("Items." + type + "." + id + ".Material");
				int ItemShort = cfg.getInt("Items." + type + "." + id + ".Short");
				
				Material materialcfg = Material.getMaterial(Item);
				ItemStack itemcfg = new ItemStack(materialcfg, 1, (short) ItemShort);
				
				if (items.getType().equals(itemcfg.getType())) {
					
					containsItem = true;
					
				}
			
			
			
			}
		}
		
		return containsItem;
		
	}
	
	
	
	public int getItemAnzahl(Inventory inv, ItemStack item) {
		
		
		ItemStack[] is = inv.getContents();
		
		int Anzahl = 0;
		
	    for (int i = 0; i < is.length; i++) {
	    	if (is[i] != null) {
	    	if (is[i].equals(item)) {
	    		int Alpha = is[i].getAmount();
	    		Anzahl = Anzahl + Alpha;
	    		
	    	}
	    	}
	    }
		
		
		return Anzahl;
	}
	
	
	
	
}
