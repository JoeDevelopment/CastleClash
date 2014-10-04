package net.net76.joedevelopment;

import java.util.ArrayList;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
			public void onPlayerJoin(PlayerJoinEvent e) {
				if(teamint == 1) {
					
				}
			}
		}, this);
	}
	
}
