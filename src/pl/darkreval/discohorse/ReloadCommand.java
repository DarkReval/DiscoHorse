package pl.darkreval.discohorse;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor
{
	DiscoHorse plugin;

	public ReloadCommand(DiscoHorse plugin)
	{
		this.plugin = plugin;
		this.plugin.getCommand("dhreload").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if ((sender instanceof Player))
		{
			Player player = (Player)sender;
			if (args.length == 0)
			{
				if(player.hasPermission("discohorse.reload")) {
					this.plugin.reloadConfig();
					player.sendMessage(ChatColor.GREEN + "Success!");
				}else {
					player.sendMessage(ChatColor.RED + "You dont have permissions to use that command!");
				}
			}
		}
		return false;
	}

}
