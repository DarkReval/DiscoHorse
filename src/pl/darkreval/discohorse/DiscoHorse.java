package pl.darkreval.discohorse;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscoHorse extends JavaPlugin {

	private static DiscoHorse plugin;
	FileConfiguration cfg;
	private PluginDescriptionFile pluginPdf;
	EnterExitListener eel;
	Scheduler scheduler;
	ReloadCommand reloadCommand;

	public void onEnable() {
		pluginPdf = getDescription();
		getLogger().info(pluginPdf.getName() + "[" + pluginPdf.getVersion() + "] has been enabled, initializing..");
		plugin = this;
		cfg = plugin.getConfig();
		saveDefaultConfig();
		this.scheduler = new Scheduler(this);
		this.eel = new EnterExitListener(this);
		this.reloadCommand = new ReloadCommand(this);
	}

}
