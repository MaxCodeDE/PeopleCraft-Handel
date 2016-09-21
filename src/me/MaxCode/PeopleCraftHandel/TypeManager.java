package me.MaxCode.PeopleCraftHandel;

import org.bukkit.ChatColor;

public class TypeManager {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	
	public String holz = str + "Holz";
	public String stein = str + "Stein";
	public String pflanzen = str + "Pflanzen";
	public String baustoffe = str + "Baustoffe";
	
	public String nahrung = str + "Nahrung";
	public String werkstoffe = str + "Werkstoffe";
	//TO-DO
	
	public String verkaufen = str + "Verkaufen";
	
	
	public String getDisplaynameByCreateInvString(String type) {
		
		String Displayname = "";
		
		
		if (type.equalsIgnoreCase("Holz")) {
			Displayname = holz;
		}
		
		if (type.equalsIgnoreCase("Stein")) {
			Displayname = stein;
		}
		
		if (type.equalsIgnoreCase("Pflanzen")) {
			Displayname = pflanzen;
		}
		
		if (type.equalsIgnoreCase("Baustoffe")) {
			Displayname = baustoffe;
		}
		
		if (type.equalsIgnoreCase("Nahrung")) {
			Displayname = nahrung;
		}
		
		if (type.equalsIgnoreCase("Werkstoffe")) {
			Displayname = werkstoffe;
		}
		
		
		
		if (type.equalsIgnoreCase("Verkaufen")) {
			Displayname = verkaufen;
		}
		
		System.out.println(Displayname);
		return Displayname;
	}
	
	
	
	
	
	public String getInvStringByDisplayname(String typename) {
		
		String InvString = "";
		
		if (typename.equalsIgnoreCase(holz)) {
			InvString = "Holz";
		}
		
		if (typename.equalsIgnoreCase(stein)) {
			InvString = "Stein";
		}
		
		if (typename.equalsIgnoreCase(pflanzen)) {
			InvString = "Pflanzen";
		}
		
		if (typename.equalsIgnoreCase(baustoffe)) {
			InvString = "Baustoffe";
		}
		
		if (typename.equalsIgnoreCase(nahrung)) {
			InvString = "Nahrung";
		}
		
		if (typename.equalsIgnoreCase(werkstoffe)) {
			InvString = "Werkstoffe";
		}
		
		
		
		if (typename.equalsIgnoreCase(verkaufen)) {
			InvString = "Verkaufen";
		}
		
		return InvString;
	}
	
	
	
}
