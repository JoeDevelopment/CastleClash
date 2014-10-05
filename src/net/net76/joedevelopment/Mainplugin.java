package net.net76.joedevelopment;

import java.util.ArrayList;

import org.bukkit.*;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Mainplugin extends JavaPlugin {
	
	private static int teamint = 1;
	private static int team1playeramount = 0;
	private static int team2playeramount = 0;
	private static ArrayList<Player> team1players = new ArrayList<Player>();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listener() {
			@EventHandler
			public void onPlayerInteract(PlayerInteractEvent e) {
				if(e.getClickedBlock() != null && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
					if(e.getClickedBlock().getType().equals(Material.SIGN_POST) || e.getClickedBlock().getType().equals(Material.WALL_SIGN)) {
						Sign s = (Sign)e.getClickedBlock().getState();
						if(s.getLine(0).equalsIgnoreCase(ChatColor.DARK_AQUA+"[CastleClash]") && s.getLine(1).equalsIgnoreCase("JOIN")) {
							e.getPlayer().sendMessage("This has not been implemented yet.");
						}
					} else if(e.getClickedBlock().getType().equals(Material.OBSIDIAN)) {
						// Check coords, Implement later
					}
				}
			}
		}, this);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player sender = (Player)s;
		if(c.getName().equalsIgnoreCase("addshopblock")) {
			if(sender.getWorld().getBlockAt(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ()).getType().equals(Material.OBSIDIAN)) {
				if(ShopKeeper.contains(sender.getLocation().getBlockX(),sender.getLocation().getBlockY(),sender.getLocation().getBlockZ())) {
					sender.sendMessage("§3[CastleClash: ADMIN] §cA shop is already registered here.");
				} else {
					
				}
			} else {
				sender.sendMessage("§3[CastleClash: ADMIN] §cThere must be obsidian under you to register a shop.");
			}
		}
		return false;
	}
}
