package me.MaxCode.PeopleCraftHandel;

import java.io.File;
import java.util.ArrayList;

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

public class HandelManager {

	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	public Economy econ;
	public PeopleCraftHandel pch;
	
	@SuppressWarnings("static-access")
	public HandelManager(PeopleCraftHandel class1) {
		econ = pch.economy;
		pch = class1;
	}
	
	//Bug: Letzten Syntax hinzu und wieder loeschen wenn alles Rot 
	
	public void openHandelMenu(Player p, String typename) {
		
		
		TypeManager tm = new TypeManager();
		String type = tm.getInvStringByDisplayname(typename);
		
		Inventory inv = Bukkit.createInventory(p, 36, str + type);
		
		int SlotID = 0;
		
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Items.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		
		for (String s : cfg.getConfigurationSection("Items." + type).getKeys(false)) {
			
			String Item = cfg.getString("Items." + type + "." + s + ".Material");
			int ItemShort = cfg.getInt("Items." + type + "." + s + ".Short");
			int ItemKaufPreis = cfg.getInt("Items." + type + "." + s + ".KaufPreis");
			int ItemVerkaufPreis = cfg.getInt("Items." + type + "." + s + ".VerKaufPreis");
			
			Material material = Material.getMaterial(Item);
			ItemStack item = new ItemStack(material, 1, (short) ItemShort);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► " + Item + ":" + ItemShort);
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("");
			lore.add(ChatColor.DARK_GRAY + "Kauf Preis: " + ChatColor.GRAY + ItemKaufPreis + " Bux");
			lore.add(ChatColor.DARK_GRAY + "Verkauf Preis: " + ChatColor.GRAY + ItemVerkaufPreis + " Bux");
			meta.setLore(lore);
			item.setItemMeta(meta);
			lore.clear();
			
			inv.setItem(SlotID, item);
			SlotID++;
			
		}
		
		
		
		p.openInventory(inv);
		
	}
	
	
	public void openKaufMenu(final Player p, ItemStack item, String type) {
		
		final Inventory inv = Bukkit.createInventory(p, 36, str + type);
		
		ItemStack info = new ItemStack(Material.BOOK);
		ItemMeta infometa = info.getItemMeta();
		infometa.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► Wieviel mochtest du kaufen?");
		info.setItemMeta(infometa);
		inv.setItem(4, info);
		
		int SlotID = 0;
		
		for (SlotID = 20; SlotID <= 24; SlotID++) {
			
			ItemMeta meta = item.getItemMeta();
			if (SlotID == 20) {
				item.setAmount(1);
				meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► Anzahl: 1");
			}
			if (SlotID == 21) {
				item.setAmount(8);
				meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► Anzahl: 8");
			}
			if (SlotID == 22) {
				item.setAmount(16);
				meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► Anzahl: 16");
			}
			if (SlotID == 23) {
				item.setAmount(32);
				meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► Anzahl: 32");
			}
			if (SlotID == 24) {
				item.setAmount(64);
				meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► Anzahl: 64");
			}
			
			meta.setLore(null);
			item.setItemMeta(meta);
			inv.setItem(SlotID, item);
			
		}
		
				p.openInventory(inv);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void kauf(Player p, ItemStack item, String type, int Anzahl) {
		
		if (p != null && item != null && type != null && Anzahl != 0) {
		
		if (this.hasAnEmptyItemSlot(p) == true) {
			
			int KaufPreis = this.getKaufPreis(item, type);
			
			KaufPreis = KaufPreis * Anzahl;
			
			if (econ.has(p, KaufPreis)) {
				econ.withdrawPlayer(p, KaufPreis);
			
			Material mat = Material.getMaterial(item.getType().toString());
			ItemStack newItem = new ItemStack(mat, Anzahl, item.getData().getData());
			
			p.getInventory().addItem(newItem);
			p.sendMessage(str + "Item wurde erfolgreich gekauft!");
			
			EffectManager em = new EffectManager();
			em.playEffectToPlayer(p);
		
		} else {
			p.sendMessage(str + "Du hast nicht genug Bux!");
		}
			
		} else {
			p.sendMessage(str + "Leere bitte voher dein Inventar!");
		}
			
		} else {
			p.sendMessage(str + "Ein Fehler ist aufgetreten!");
		}
		
		p.closeInventory();
	}
	
	
	
	public boolean hasAnEmptyItemSlot(Player p) {
		
		boolean hasEmptyItemSlot = false;
		
			ItemStack[] items = p.getInventory().getContents();
		
			for (ItemStack is : items) {
				if (is == null) {
					
					hasEmptyItemSlot = true;
					
			}
		}
			
		
		
		return hasEmptyItemSlot;
	}
	
	
	@SuppressWarnings("deprecation")
	public int getKaufPreis(ItemStack item, String type) {
		
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Items.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int ItemKaufPreis = 0;
				
		for (String s : cfg.getConfigurationSection("Items." + type).getKeys(false)) {
			
			String Item = cfg.getString("Items." + type + "." + s + ".Material");
			int ItemShort = cfg.getInt("Items." + type + "." + s + ".Short");
			
			
			Material materialcfg = Material.getMaterial(Item);
			ItemStack itemcfg = new ItemStack(materialcfg, 1, (short) ItemShort);
			
			if (materialcfg.equals(item.getType()) && itemcfg.getData().getData() == item.getData().getData()) {
				
				ItemKaufPreis = cfg.getInt("Items." + type + "." + s + ".KaufPreis");
				
			}
			
			
			
			
		}
			
			
			return ItemKaufPreis;
	}
}