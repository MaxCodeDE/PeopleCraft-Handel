package me.MaxCode.PeopleCraftHandel;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class EffectManager {

	
	
	public void playEffectToPlayer(Player p) {
		
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		p.getLocation().getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 5);
		
		p.getLocation().getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		
	}
	
	
	
	
}
