package pl.darkreval.discohorse;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Horse;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Scheduler {
	
	DiscoHorse plugin;
	
	public Scheduler(DiscoHorse plugin) {
		this.plugin = plugin;
		start();
	}
	
	private void start() {
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {;
				for(Horse h : Utils.horseList) {
					h.setColor(Utils.randColor());
					h.setStyle(Utils.randStyle());
					if(plugin.cfg.getBoolean("Settings.Disco.armor")) {
						if(Utils.randBool()) {
							h.getInventory().setArmor(Utils.randArmor());
						}else {
							if(h.getInventory().getArmor() != null) {
								h.getInventory().remove(h.getInventory().getArmor());
							}
						}
					}
					if(plugin.cfg.getBoolean("Settings.Effects.playEffect")) {
						Location x = new Location(h.getLocation().getWorld(), h.getLocation().getX(), h.getLocation().getY() + 1, h.getLocation().getZ());
						h.getWorld().playEffect(x, Effect.valueOf(plugin.cfg.getString("Settings.Effects.effect")), plugin.cfg.getInt("Settings.Effects.effectAmount"));
					}
				}
			}

		}, plugin.cfg.getInt("Settings.Disco.repeatEvery"), 20L);
	}

}
