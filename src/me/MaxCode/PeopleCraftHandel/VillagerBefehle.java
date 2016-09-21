package me.MaxCode.PeopleCraftHandel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VillagerBefehle implements CommandExecutor {

	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	public PeopleCraftHandel pch;
	public VillagerBefehle(PeopleCraftHandel class1) {
		pch = class1;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("handelv")) {
			
			
			// /handelv erstellen -> Auswahl Menu
			if (args.length == 1) {
			if (args[0].equalsIgnoreCase("erstellen")) {
				Inventory inv = Bukkit.createInventory(p, 9, str + "Erstellen");
				
				ItemStack holz = new ItemStack(Material.WOOD);
				ItemMeta holzm = holz.getItemMeta();
				holzm.setDisplayName("Holz");
				holz.setItemMeta(holzm);
				inv.setItem(0, holz);
				
				ItemStack stein = new ItemStack(Material.STONE);
				ItemMeta steinm = stein.getItemMeta();
				steinm.setDisplayName("Stein");
				stein.setItemMeta(steinm);
				inv.setItem(1, stein);
				
				ItemStack pflanzen = new ItemStack(Material.RED_ROSE);
				ItemMeta pflanzenm = pflanzen.getItemMeta();
				pflanzenm.setDisplayName("Pflanzen");
				pflanzen.setItemMeta(pflanzenm);
				inv.setItem(2, pflanzen);
				
				ItemStack baustoffe = new ItemStack(Material.GLASS);
				ItemMeta baustoffem = baustoffe.getItemMeta();
				baustoffem.setDisplayName("Baustoffe");
				baustoffe.setItemMeta(baustoffem);
				inv.setItem(3, baustoffe);
				
				ItemStack nahrung = new ItemStack(Material.COOKED_BEEF);
				ItemMeta nahrungm = nahrung.getItemMeta();
				nahrungm.setDisplayName("Nahrung");
				nahrung.setItemMeta(nahrungm);
				inv.setItem(4, nahrung);
				
				ItemStack werkstoffe = new ItemStack(Material.DIAMOND);
				ItemMeta werkstoffem = werkstoffe.getItemMeta();
				werkstoffem.setDisplayName("Werkstoffe");
				werkstoffe.setItemMeta(werkstoffem);
				inv.setItem(5, werkstoffe);
				
				
				ItemStack verkaufen = new ItemStack(Material.REDSTONE_TORCH_ON);
				ItemMeta verkaufenm = verkaufen.getItemMeta();
				verkaufenm.setDisplayName("Verkaufen");
				verkaufen.setItemMeta(verkaufenm);
				inv.setItem(8, verkaufen);
				
				p.openInventory(inv);
				
			}
			}
			
			
			// /handelv loeschen -> Shop-Villager loeschen
			if (args.length == 1) {
			if (args[0].equalsIgnoreCase("loeschen")) {
				VillagerManager vm = new VillagerManager(pch);
				vm.VillagerLoeschen(p);
			}
			}
			
			
			
		}
		
		
		
		
		return false;
	}

	
	
	
	
	
	
}
