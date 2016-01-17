package pl.darkreval.discohorse;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class EnterExitListener implements Listener {
	DiscoHorse plugin;

	public EnterExitListener(DiscoHorse plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}


	@EventHandler
	public void onMount(VehicleEnterEvent e) {
		Player p = (Player) e.getEntered();
		if(p.hasPermission(this.plugin.cfg.getString("Settings.Disco.permission"))) {
			Horse h = (Horse) e.getVehicle();
			if(Utils.horseList.contains(h)) {
				Utils.horseList.remove(h);
			}else {
				Utils.horseList.add(h);
			}
		}

	}

	@EventHandler
	public void onExit(VehicleExitEvent e) {
		Horse h = (Horse) e.getVehicle();
		if(Utils.horseList.contains(h)) {
			Utils.horseList.remove(h);
		}
	}

}
