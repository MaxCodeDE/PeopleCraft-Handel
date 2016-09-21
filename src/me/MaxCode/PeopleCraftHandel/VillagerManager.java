package me.MaxCode.PeopleCraftHandel;

import java.io.File;
import java.io.IOException;

import net.minecraft.server.v1_8_R1.NBTTagCompound;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerManager implements Listener {

	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	public PeopleCraftHandel pch;
	public VillagerManager(PeopleCraftHandel class1) {
		pch = class1;
	}
	
	@EventHandler
	public void VillagerErstellen(InventoryClickEvent e) {
		
		
		if (e.getInventory().getName().equals(str + "Erstellen")) {
		if (e.getSlotType() != SlotType.OUTSIDE) {
		if (e.getCurrentItem() != null) {
			
			String shoptype = e.getCurrentItem().getItemMeta().getDisplayName();
			
			Player p = (Player) e.getWhoClicked();
			
		if (this.canCreateShopVillager(shoptype) == false) {
			
			TypeManager tm = new TypeManager();
			String shopname = tm.getDisplaynameByCreateInvString(shoptype);
			
			Location loc = p.getLocation();
			
			Villager v = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
			this.setNoAI(v);
			v.setNoDamageTicks(Integer.MAX_VALUE);
			v.setCustomName(shopname);
			v.setCustomNameVisible(true);
			v.setCanPickupItems(false);
			//TO-DO  setCustomNameVisible geht nicht
			
			
			this.saveVillagerToCfg(loc, shoptype);
			
			
			p.closeInventory();
			loc.getWorld().save();
			p.sendMessage(str + "Villager-Shop wurde erstellt!");
			
		} else {
			p.sendMessage(str + "Dieser Villager-Shop wurde bereits erstellt!");
		}
		}
		}
		}
		
	}
	
	
	public void saveVillagerToCfg(Location loc, String type) {
		
		String w = loc.getWorld().getName();
		double locX = loc.getX();
		double locY = loc.getY();
		double locZ = loc.getZ();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();
		
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Villager.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		
		cfg.set("Villager." + type + ".Location" + ".World", w);
		cfg.set("Villager." + type + ".Location" + ".locX", locX);
		cfg.set("Villager." + type + ".Location" + ".locY", locY);
		cfg.set("Villager." + type + ".Location" + ".locZ", locZ);
		cfg.set("Villager." + type + ".Location" + ".Pitch", pitch);
		cfg.set("Villager." + type + ".Location" + ".Yaw", yaw);
		cfg.set("Villager." + type + ".BereitsErstellt", "Ja");
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public boolean canCreateShopVillager(String type) {
		
		boolean bereitsErstellt = false;
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Villager.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if (cfg.isSet("Villager.")) {
		if (cfg.get("Villager." + type + ".BereitsErstellt") == "Ja") {
			bereitsErstellt = true;
		}
		if (cfg.get("Villager." + type + ".BereitsErstellt") == "Nein") {
			bereitsErstellt = false;
		}
		}
		
		return bereitsErstellt;
	}
	
	
	
	//Unused
	@SuppressWarnings("unused")
	public int getVillagers() {
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Villager.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int villagers = 0;
		
		for (String s : cfg.getConfigurationSection("Villager.").getKeys(true)) {
			
			villagers++;
			
		}
		
		
		
		
		return villagers;
		
	}
	
	
	
	public void VillagerLoeschen(Player p) {
		
		
		for (Entity ent : p.getNearbyEntities(5, 5, 5)) {
			
			if (ent instanceof Villager) {
			if (((Villager) ent).getCustomName() != null) {
			if (((Villager) ent).getCustomName().contains(str)) {
				
				String typename = ent.getCustomName();
				
				TypeManager tm = new TypeManager();
				String type = tm.getInvStringByDisplayname(typename);
				
				File file = new File("plugins/PeopleCraft-Handel/" + "Villager.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

				
				cfg.set("Villager." + type + ".Location" + ".World", 0);
				cfg.set("Villager." + type + ".Location" + ".locX", 0);
				cfg.set("Villager." + type + ".Location" + ".locY", 0);
				cfg.set("Villager." + type + ".Location" + ".locZ", 0);
				cfg.set("Villager." + type + ".Location" + ".Pitch", 0);
				cfg.set("Villager." + type + ".Location" + ".Yaw", 0);
				cfg.set("Villager." + type + ".BereitsErstellt", "Nein");
				
				try {
					cfg.save(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				ent.remove();
				ent.getWorld().save();
			
				p.sendMessage(str + "Villager wurde geloescht!");
			}
			}
			}
			
			
		}
		
	}
	
	
	public void setNoAI(Entity v) {
		
	    net.minecraft.server.v1_8_R1.Entity nmsEntity = ((CraftEntity) v).getHandle();
	    NBTTagCompound tag = nmsEntity.getNBTTag();
	    if (tag == null) {
	        tag = new NBTTagCompound();
	    }
	    nmsEntity.c(tag);
	    tag.setInt("NoAI", 1);
	    nmsEntity.f(tag);
	}
	
	
	public void delNoAI(Entity v) {
		
	    net.minecraft.server.v1_8_R1.Entity nmsEntity = ((CraftEntity) v).getHandle();
	    NBTTagCompound tag = nmsEntity.getNBTTag();
	    if (tag == null) {
	        tag = new NBTTagCompound();
	    }
	    nmsEntity.c(tag);
	    tag.setInt("NoAI", 0);
	    nmsEntity.f(tag);
	}
	
	
	
	public void setVillagerTarget(Player p, final Entity en) {
		
		final Location loc = en.getLocation();
		
		this.delNoAI(en);
		((Villager) en).setTarget(p);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(pch, new Runnable() {
			public void run() {
				en.teleport(loc);
				setNoAI(en);
			}
		}, 10L);
		
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void villagerDE(EntityDeathEvent e){
		
		String name = e.getEntity().getCustomName();
		
		if (name != null) {
		if (name.contains(str)) {
			
			e.getEntity().setHealth(20);
			e.getEntity().setNoDamageTicks(Integer.MAX_VALUE);
			
		}
		}
	}
	
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		String name = e.getEntity().getCustomName();
		
		if (name != null) {
		if (name.contains(str)) {
			
			e.setCancelled(true);
			
		}
		}
		
	}
	
	
	@EventHandler
	public void PI(PlayerInteractEntityEvent e) {
		
		
		Entity en = e.getRightClicked();
		Player p = e.getPlayer();
		
			if (en instanceof Villager) {
			if (((Villager) en).getCustomName().contains(str) && !((Villager) en).getCustomName().equals(str + "Verkaufen")) {
			
				e.setCancelled(true);
				((Villager) en).setNoDamageTicks(Integer.MAX_VALUE);
				
				String typename = en.getCustomName();
				
				this.setVillagerTarget(p, en);
				
				HandelManager hm = new HandelManager(pch);
				hm.openHandelMenu(p, typename);
			
			
			}
			}
	}
	
	
	
	
}
