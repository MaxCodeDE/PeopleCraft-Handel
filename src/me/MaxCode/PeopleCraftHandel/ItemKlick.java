package me.MaxCode.PeopleCraftHandel;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemKlick implements Listener {

	
	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	public PeopleCraftHandel pch;
	public ItemKlick(PeopleCraftHandel class1) {
		pch = class1;
	}
	
	
	@EventHandler
	public void ItemKlickVoid(InventoryClickEvent e) {
		
		
		
		if (e.getInventory().getName().contains(str) && !e.getInventory().getName().equals(str + "Verkaufen")) {
			e.setCancelled(true);
		if (!e.getInventory().getName().equals(str + "Kaufen") && !e.getInventory().getName().equals(str + "Erstellen")) {
		if (e.getSlotType() != SlotType.OUTSIDE) {
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			
			Player p = (Player) e.getWhoClicked();
			Inventory inv = e.getClickedInventory();
		if (this.containsInfoBuch(p, inv) == false) {
			
			p.closeInventory();
			
			ItemStack item = e.getCurrentItem();
			
			TypeManager tm = new TypeManager();
			String type = tm.getInvStringByDisplayname(e.getInventory().getTitle());
			
			HandelManager hm = new HandelManager(pch);
			hm.openKaufMenu(p, item, type);
			
		}
		}
		}
		}
		}
			
		
	}
	
	
	@EventHandler
	public void ItemKaufKlickVoid(InventoryClickEvent e) {
		
		if (e.getInventory().getName().contains(str) && !e.getInventory().getName().equals(str + "Verkaufen")) {
			e.setCancelled(true);
		if (!e.getInventory().getName().equals(str + "Erstellen")) {
		if (e.getSlotType() != SlotType.OUTSIDE) {
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
		if (!e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "► Wieviel mochtest du kaufen?")) {
			
			Player p = (Player) e.getWhoClicked();
			Inventory inv = e.getClickedInventory();
		if (this.containsInfoBuch(p, inv) == true) {
			
			
			p.closeInventory();
			
			ItemStack item = e.getCurrentItem();
			
			TypeManager tm = new TypeManager();
			String type = tm.getInvStringByDisplayname(e.getInventory().getTitle());
			
			
			int Anzahl = this.getItemAnzahl(inv, item);
			
			HandelManager hm = new HandelManager(pch);
			hm.kauf(p, item, type, Anzahl);
			
		}
		}
		}
		}
		}
		}
			
		
	}
	
	
	public boolean containsInfoBuch(Player p, Inventory inv) {
		
		boolean containsBuch = false;
		
		for(ItemStack item : inv.getContents()) {
			
			if (item != null) {
			if (item.getItemMeta().hasDisplayName()) {
			if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "► Wieviel mochtest du kaufen?")) {	
				
					containsBuch = true;
					
			}
			}
			}
		}
		
		
		
		return containsBuch;
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
