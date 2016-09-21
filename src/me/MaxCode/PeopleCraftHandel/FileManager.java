package me.MaxCode.PeopleCraftHandel;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {

	
	
	public void checkFiles() {
		
		
		File file = new File("plugins/PeopleCraft-Handel/" + "Villager.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File file2 = new File("plugins/PeopleCraft-Handel/" + "Items.yml");
		FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		if (!file2.exists()) {
			
			//Holz
			cfg2.set("Items." + "Holz" + ".0" + ".Material" , "LOG");
			cfg2.set("Items." + "Holz" + ".0" + ".Short" , 0);
			cfg2.set("Items." + "Holz" + ".0" + ".KaufPreis", 100);
			cfg2.set("Items." + "Holz" + ".0" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Holz" + ".1" + ".Material" , "LOG");
			cfg2.set("Items." + "Holz" + ".1" + ".Short" , 1);
			cfg2.set("Items." + "Holz" + ".1" + ".KaufPreis", 200);
			cfg2.set("Items." + "Holz" + ".1" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Holz" + ".2" + ".Material" , "LOG");
			cfg2.set("Items." + "Holz" + ".2" + ".Short" , 2);
			cfg2.set("Items." + "Holz" + ".2" + ".KaufPreis", 200);
			cfg2.set("Items." + "Holz" + ".2" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Holz" + ".3" + ".Material" , "LOG");
			cfg2.set("Items." + "Holz" + ".3" + ".Short" , 3);
			cfg2.set("Items." + "Holz" + ".3" + ".KaufPreis", 200);
			cfg2.set("Items." + "Holz" + ".3" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Holz" + ".4" + ".Material" , "LOG_2");
			cfg2.set("Items." + "Holz" + ".4" + ".Short" , 0);
			cfg2.set("Items." + "Holz" + ".4" + ".KaufPreis", 200);
			cfg2.set("Items." + "Holz" + ".4" + ".VerKaufPreis", 100);
			
			cfg2.set("Items." + "Holz" + ".5" + ".Material" , "LOG_2");
			cfg2.set("Items." + "Holz" + ".5" + ".Short" , 1);
			cfg2.set("Items." + "Holz" + ".5" + ".KaufPreis", 200);
			cfg2.set("Items." + "Holz" + ".5" + ".VerKaufPreis", 100);
			//Holz
			
			//Stein
			cfg2.set("Items." + "Stein" + ".0" + ".Material" , "COBBLESTONE");
			cfg2.set("Items." + "Stein" + ".0" + ".Short" , 0);
			cfg2.set("Items." + "Stein" + ".0" + ".KaufPreis", 50);
			cfg2.set("Items." + "Stein" + ".0" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Stein" + ".1" + ".Material" , "STONE");
			cfg2.set("Items." + "Stein" + ".1" + ".Short" , 0);
			cfg2.set("Items." + "Stein" + ".1" + ".KaufPreis", 100);
			cfg2.set("Items." + "Stein" + ".1" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Stein" + ".2" + ".Material" , "STONE");
			cfg2.set("Items." + "Stein" + ".2" + ".Short" , 1);
			cfg2.set("Items." + "Stein" + ".2" + ".KaufPreis", 200);
			cfg2.set("Items." + "Stein" + ".2" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Stein" + ".3" + ".Material" , "STONE");
			cfg2.set("Items." + "Stein" + ".3" + ".Short" , 2);
			cfg2.set("Items." + "Stein" + ".3" + ".KaufPreis", 200);
			cfg2.set("Items." + "Stein" + ".3" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Stein" + ".4" + ".Material" , "STONE");
			cfg2.set("Items." + "Stein" + ".4" + ".Short" , 3);
			cfg2.set("Items." + "Stein" + ".4" + ".KaufPreis", 200);
			cfg2.set("Items." + "Stein" + ".4" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Stein" + ".5" + ".Material" , "STONE");
			cfg2.set("Items." + "Stein" + ".5" + ".Short" , 4);
			cfg2.set("Items." + "Stein" + ".5" + ".KaufPreis", 200);
			cfg2.set("Items." + "Stein" + ".5" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Stein" + ".6" + ".Material" , "STONE");
			cfg2.set("Items." + "Stein" + ".6" + ".Short" , 5);
			cfg2.set("Items." + "Stein" + ".6" + ".KaufPreis", 200);
			cfg2.set("Items." + "Stein" + ".6" + ".VerKaufPreis", 50);
			//Stein
			
			//Pflanzen
			cfg2.set("Items." + "Pflanzen" + ".0" + ".Material" , "SAPLING");
			cfg2.set("Items." + "Pflanzen" + ".0" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".0" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".0" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".1" + ".Material" , "SAPLING");
			cfg2.set("Items." + "Pflanzen" + ".1" + ".Short" , 1);
			cfg2.set("Items." + "Pflanzen" + ".1" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".1" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".2" + ".Material" , "SAPLING");
			cfg2.set("Items." + "Pflanzen" + ".2" + ".Short" , 2);
			cfg2.set("Items." + "Pflanzen" + ".2" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".2" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".3" + ".Material" , "SAPLING");
			cfg2.set("Items." + "Pflanzen" + ".3" + ".Short" , 3);
			cfg2.set("Items." + "Pflanzen" + ".3" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".3" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".4" + ".Material" , "SAPLING");
			cfg2.set("Items." + "Pflanzen" + ".4" + ".Short" , 4);
			cfg2.set("Items." + "Pflanzen" + ".4" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".4" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".5" + ".Material" , "SAPLING");
			cfg2.set("Items." + "Pflanzen" + ".5" + ".Short" , 5);
			cfg2.set("Items." + "Pflanzen" + ".5" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".5" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".6" + ".Material" , "LEAVES");
			cfg2.set("Items." + "Pflanzen" + ".6" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".6" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".6" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".7" + ".Material" , "LEAVES");
			cfg2.set("Items." + "Pflanzen" + ".7" + ".Short" , 1);
			cfg2.set("Items." + "Pflanzen" + ".7" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".7" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".8" + ".Material" , "LEAVES");
			cfg2.set("Items." + "Pflanzen" + ".8" + ".Short" , 2);
			cfg2.set("Items." + "Pflanzen" + ".8" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".8" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".9" + ".Material" , "LEAVES");
			cfg2.set("Items." + "Pflanzen" + ".9" + ".Short" , 3);
			cfg2.set("Items." + "Pflanzen" + ".9" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".9" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".10" + ".Material" , "YELLOW_FLOWER");
			cfg2.set("Items." + "Pflanzen" + ".10" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".10" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".10" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".11" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".11" + ".Short" , 1);
			cfg2.set("Items." + "Pflanzen" + ".11" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".11" + ".VerKaufPreis", 0);
			
			cfg2.set("Items." + "Pflanzen" + ".12" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".12" + ".Short" , 1);
			cfg2.set("Items." + "Pflanzen" + ".12" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".12" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".13" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".13" + ".Short" , 2);
			cfg2.set("Items." + "Pflanzen" + ".13" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".13" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".14" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".14" + ".Short" , 3);
			cfg2.set("Items." + "Pflanzen" + ".14" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".14" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".15" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".15" + ".Short" , 4);
			cfg2.set("Items." + "Pflanzen" + ".15" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".15" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".16" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".16" + ".Short" , 5);
			cfg2.set("Items." + "Pflanzen" + ".16" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".16" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".17" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".17" + ".Short" , 6);
			cfg2.set("Items." + "Pflanzen" + ".17" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".17" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".18" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".18" + ".Short" , 7);
			cfg2.set("Items." + "Pflanzen" + ".18" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".18" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".19" + ".Material" , "RED_ROSE");
			cfg2.set("Items." + "Pflanzen" + ".19" + ".Short" , 8);
			cfg2.set("Items." + "Pflanzen" + ".19" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".19" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".20" + ".Material" , "CACTUS");
			cfg2.set("Items." + "Pflanzen" + ".20" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".20" + ".KaufPreis", 50);
			cfg2.set("Items." + "Pflanzen" + ".20" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Pflanzen" + ".21" + ".Material" , "SUGAR_CANE");
			cfg2.set("Items." + "Pflanzen" + ".21" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".21" + ".KaufPreis", 10);
			cfg2.set("Items." + "Pflanzen" + ".21" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Pflanzen" + ".22" + ".Material" , "PUMPKIN");
			cfg2.set("Items." + "Pflanzen" + ".22" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".22" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".22" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".23" + ".Material" , "WATER_LILY");
			cfg2.set("Items." + "Pflanzen" + ".23" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".23" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".23" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".24" + ".Material" , "DOUBLE_PLANT");
			cfg2.set("Items." + "Pflanzen" + ".24" + ".Short" , 0);
			cfg2.set("Items." + "Pflanzen" + ".24" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".24" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".25" + ".Material" , "DOUBLE_PLANT");
			cfg2.set("Items." + "Pflanzen" + ".25" + ".Short" , 1);
			cfg2.set("Items." + "Pflanzen" + ".25" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".25" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".26" + ".Material" , "DOUBLE_PLANT");
			cfg2.set("Items." + "Pflanzen" + ".26" + ".Short" , 2);
			cfg2.set("Items." + "Pflanzen" + ".26" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".26" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".27" + ".Material" , "DOUBLE_PLANT");
			cfg2.set("Items." + "Pflanzen" + ".27" + ".Short" , 3);
			cfg2.set("Items." + "Pflanzen" + ".27" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".27" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".28" + ".Material" , "DOUBLE_PLANT");
			cfg2.set("Items." + "Pflanzen" + ".28" + ".Short" , 4);
			cfg2.set("Items." + "Pflanzen" + ".28" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".28" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Pflanzen" + ".29" + ".Material" , "DOUBLE_PLANT");
			cfg2.set("Items." + "Pflanzen" + ".29" + ".Short" , 5);
			cfg2.set("Items." + "Pflanzen" + ".29" + ".KaufPreis", 100);
			cfg2.set("Items." + "Pflanzen" + ".29" + ".VerKaufPreis", 50);
			//Pflanzen
			
			//Baustoffe
			cfg2.set("Items." + "Baustoffe" + ".0" + ".Material" , "DIRT");
			cfg2.set("Items." + "Baustoffe" + ".0" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".0" + ".KaufPreis", 10);
			cfg2.set("Items." + "Baustoffe" + ".0" + ".VerKaufPreis", 1);
			
			cfg2.set("Items." + "Baustoffe" + ".1" + ".Material" , "GRASS");
			cfg2.set("Items." + "Baustoffe" + ".1" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".1" + ".KaufPreis", 50);
			cfg2.set("Items." + "Baustoffe" + ".1" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Baustoffe" + ".2" + ".Material" , "GLASS");
			cfg2.set("Items." + "Baustoffe" + ".2" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".2" + ".KaufPreis", 100);
			cfg2.set("Items." + "Baustoffe" + ".2" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Baustoffe" + ".3" + ".Material" , "SAND");
			cfg2.set("Items." + "Baustoffe" + ".3" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".3" + ".KaufPreis", 50);
			cfg2.set("Items." + "Baustoffe" + ".3" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Baustoffe" + ".4" + ".Material" , "WOOL");
			cfg2.set("Items." + "Baustoffe" + ".4" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".4" + ".KaufPreis", 100);
			cfg2.set("Items." + "Baustoffe" + ".4" + ".VerKaufPreis", 50);
			
			cfg2.set("Items." + "Baustoffe" + ".5" + ".Material" , "BOOKSHELF");
			cfg2.set("Items." + "Baustoffe" + ".5" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".5" + ".KaufPreis", 500);
			cfg2.set("Items." + "Baustoffe" + ".5" + ".VerKaufPreis", 100);
			
			cfg2.set("Items." + "Baustoffe" + ".6" + ".Material" , "BED");
			cfg2.set("Items." + "Baustoffe" + ".6" + ".Short" , 0);
			cfg2.set("Items." + "Baustoffe" + ".6" + ".KaufPreis", 400);
			cfg2.set("Items." + "Baustoffe" + ".6" + ".VerKaufPreis", 100);
			//Baustoffe
			
			
			//Nahrung
			cfg2.set("Items." + "Nahrung" + ".0" + ".Material" , "COOKED_BEEF");
			cfg2.set("Items." + "Nahrung" + ".0" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".0" + ".KaufPreis", 50);
			cfg2.set("Items." + "Nahrung" + ".0" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Nahrung" + ".1" + ".Material" , "COOKED_CHICKEN");
			cfg2.set("Items." + "Nahrung" + ".1" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".1" + ".KaufPreis", 50);
			cfg2.set("Items." + "Nahrung" + ".1" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Nahrung" + ".2" + ".Material" , "COOKIE");
			cfg2.set("Items." + "Nahrung" + ".2" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".2" + ".KaufPreis", 50);
			cfg2.set("Items." + "Nahrung" + ".2" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Nahrung" + ".3" + ".Material" , "COOKED_FISH");
			cfg2.set("Items." + "Nahrung" + ".3" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".3" + ".KaufPreis", 50);
			cfg2.set("Items." + "Nahrung" + ".3" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Nahrung" + ".4" + ".Material" , "CAKE");
			cfg2.set("Items." + "Nahrung" + ".4" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".4" + ".KaufPreis", 100);
			cfg2.set("Items." + "Nahrung" + ".4" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Nahrung" + ".5" + ".Material" , "POTATO_ITEM");
			cfg2.set("Items." + "Nahrung" + ".5" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".5" + ".KaufPreis", 50);
			cfg2.set("Items." + "Nahrung" + ".5" + ".VerKaufPreis", 10);
			
			cfg2.set("Items." + "Nahrung" + ".6" + ".Material" , "COOKED_RABBIT");
			cfg2.set("Items." + "Nahrung" + ".6" + ".Short" , 0);
			cfg2.set("Items." + "Nahrung" + ".6" + ".KaufPreis", 50);
			cfg2.set("Items." + "Nahrung" + ".6" + ".VerKaufPreis", 10);
			//Nahrung
			
			
			//Werkstoffe
			cfg2.set("Items." + "Werkstoffe" + ".0" + ".Material" , "COAL");
			cfg2.set("Items." + "Werkstoffe" + ".0" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".0" + ".KaufPreis", 100);
			cfg2.set("Items." + "Werkstoffe" + ".0" + ".VerKaufPreis", 40);
			
			cfg2.set("Items." + "Werkstoffe" + ".1" + ".Material" , "IRON_INGOT");
			cfg2.set("Items." + "Werkstoffe" + ".1" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".1" + ".KaufPreis", 400);
			cfg2.set("Items." + "Werkstoffe" + ".1" + ".VerKaufPreis", 100);
			
			cfg2.set("Items." + "Werkstoffe" + ".2" + ".Material" , "GOLD_INGOT");
			cfg2.set("Items." + "Werkstoffe" + ".2" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".2" + ".KaufPreis", 600);
			cfg2.set("Items." + "Werkstoffe" + ".2" + ".VerKaufPreis", 300);
			
			cfg2.set("Items." + "Werkstoffe" + ".3" + ".Material" , "REDSTONE");
			cfg2.set("Items." + "Werkstoffe" + ".3" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".3" + ".KaufPreis", 600);
			cfg2.set("Items." + "Werkstoffe" + ".3" + ".VerKaufPreis", 300);
			
			cfg2.set("Items." + "Werkstoffe" + ".4" + ".Material" , "DIAMOND");
			cfg2.set("Items." + "Werkstoffe" + ".4" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".4" + ".KaufPreis", 10000);
			cfg2.set("Items." + "Werkstoffe" + ".4" + ".VerKaufPreis", 300);
			
			cfg2.set("Items." + "Werkstoffe" + ".5" + ".Material" , "EMERALD");
			cfg2.set("Items." + "Werkstoffe" + ".5" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".5" + ".KaufPreis", 1500);
			cfg2.set("Items." + "Werkstoffe" + ".5" + ".VerKaufPreis", 800);
			
			cfg2.set("Items." + "Werkstoffe" + ".6" + ".Material" , "QUARTZ");
			cfg2.set("Items." + "Werkstoffe" + ".6" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".6" + ".KaufPreis", 600);
			cfg2.set("Items." + "Werkstoffe" + ".6" + ".VerKaufPreis", 200);
			
			cfg2.set("Items." + "Werkstoffe" + ".7" + ".Material" , "NETHER_STAR");
			cfg2.set("Items." + "Werkstoffe" + ".7" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".7" + ".KaufPreis", 150000);
			cfg2.set("Items." + "Werkstoffe" + ".7" + ".VerKaufPreis", 800);
			
			cfg2.set("Items." + "Werkstoffe" + ".8" + ".Material" , "PRISMARINE_SHARD");
			cfg2.set("Items." + "Werkstoffe" + ".8" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".8" + ".KaufPreis", 15000);
			cfg2.set("Items." + "Werkstoffe" + ".8" + ".VerKaufPreis", 800);
			
			cfg2.set("Items." + "Werkstoffe" + ".9" + ".Material" , "PRISMARINE_CRYSTALS");
			cfg2.set("Items." + "Werkstoffe" + ".9" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".9" + ".KaufPreis", 30000);
			cfg2.set("Items." + "Werkstoffe" + ".9" + ".VerKaufPreis", 800);
			
			cfg2.set("Items." + "Werkstoffe" + ".10" + ".Material" , "BLAZE_ROD");
			cfg2.set("Items." + "Werkstoffe" + ".10" + ".Short" , 0);
			cfg2.set("Items." + "Werkstoffe" + ".10" + ".KaufPreis", 700);
			cfg2.set("Items." + "Werkstoffe" + ".10" + ".VerKaufPreis", 200);
			//Werkstoffe
			
			
			try {
				cfg2.save(file2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
}
