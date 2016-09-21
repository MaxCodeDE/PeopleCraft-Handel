package me.MaxCode.PeopleCraftHandel;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Befehle implements CommandExecutor {

	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Handel" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("handel")) {
			
			
			if (args.length == 1) {
			if (args[0].equalsIgnoreCase("admin")) {
				
				p.sendMessage(str + "Villager erstellen -> /handelv erstellen");
				p.sendMessage(str + "Villager loeschen -> /handelv loeschen");
				
			}
			}
			
			
			
			
			
			
		}
		
		
		
		return false;
	}

}
