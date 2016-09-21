package me.MaxCode.PeopleCraftHandel;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VerkaufEvents implements Listener {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	public String menuName = str + "Verkaufen";
	
	
	public Economy econ;
	public PeopleCraftHandel pch;
	
	@SuppressWarnings("static-access")
	public VerkaufEvents(PeopleCraftHandel class1) {
		econ = pch.economy;
		pch = class1;
	}
	
	
	
	
	
	
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		
		if (e.getInventory().getName().equals(menuName)) {
		if (e.getSlotType() != SlotType.OUTSIDE) {
		if (e.getCurrentItem() != null) {
		if (e.getCurrentItem().hasItemMeta()) {
		if (e.getCurrentItem().getItemMeta().hasDisplayName()) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "► "  + "Items verkaufen"))	{
			
			e.setCancelled(true);
			
			Player p = (Player) e.getWhoClicked();
			
			Inventory inv = e.getInventory();
			
			VerkaufManager vm = new VerkaufManager(pch);
			vm.buyItem(inv, p);
			
			}
			}
			}
			}
			}
			}
		}
		

	
	
	
	
	
	@EventHandler
	public void onClick(PlayerInteractEntityEvent e) {
		
		Entity en = e.getRightClicked();
		Player p = e.getPlayer();
		
			if (en instanceof Villager) {
			if (((Villager) en).getCustomName().equals(menuName)) {
			
				e.setCancelled(true);
				((Villager) en).setNoDamageTicks(Integer.MAX_VALUE);
				
				VerkaufManager vm = new VerkaufManager(pch);
				vm.openVerkaufMenu(p);
				
				VillagerManager vim = new VillagerManager(pch);
				vim.setVillagerTarget(p, en);
			
			}
			}
		
		
	}
	
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		if (e.getInventory().getName().equals(menuName)) {

			Player p = (Player) e.getPlayer();
			
			
			for (ItemStack item : e.getInventory().getContents()) {
				
				if (item != null) {
				if (item.hasItemMeta()) {
				if (item.getItemMeta().hasDisplayName()) {
				if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "► "  + "Items verkaufen")) {
				
					p.getWorld().dropItemNaturally(p.getLocation(), item);
				
				}
				} else {
					p.getWorld().dropItemNaturally(p.getLocation(), item);
				}
				} else {
					p.getWorld().dropItemNaturally(p.getLocation(), item);
				}
				}
				
			}
			
			
			
			
		}
		
		
	}
	
	
	
	
}
