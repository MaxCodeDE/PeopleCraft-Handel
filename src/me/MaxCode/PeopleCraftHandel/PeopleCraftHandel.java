package me.MaxCode.PeopleCraftHandel;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class PeopleCraftHandel extends JavaPlugin {

	
	public static Economy economy = null;
	
	@Override
	public void onEnable() {
		
		FileManager fm = new FileManager();
		fm.checkFiles();
		
		System.out.println("[PeopleCraft-Handel] wurde aktiviert!");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new VillagerManager(this), this);
		pm.registerEvents(new ItemKlick(this), this);
		pm.registerEvents(new VerkaufEvents(this), this);
		
		this.getCommand("handel").setExecutor(new Befehle());
		this.getCommand("handelv").setExecutor(new VillagerBefehle(this));
		
		this.setupEconomy();
	}
	
	
	
	@Override
	public void onDisable() {
		
		
		
		
	}
	
	
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
	
	
}
