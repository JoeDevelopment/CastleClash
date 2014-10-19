package net.net76.joedevelopment;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TeamCheck {
	private static boolean team1 = false;
	private static boolean team2 = false;
	private static boolean hasRan = false;
	private static int time = 0;
	private static boolean okay = false;
	
	public static void setTeam1Ready() {
		team1 = true;
		if(team2 == true) {
			
		}
	}
	
	public static void setTeam2Ready() {
		team2 = true;
		if(team1 == true) {
			
		}
	}
	
	private static void startCountdown() {
		if(!hasRan) {
			Timer t = new Timer();
			hasRan = true;
			okay = true;
			time = 4;
			t.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					if(okay) {
						time--;
						if(time == 0) {
							okay = false;
							time = 4;
							Team1.sendToSpawn();
							Team2.sendToSpawn();
						} else {
							Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
							for(int i=0;i < players.toArray().length; i++) {
								((Player)players.toArray()[i]).sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.AQUA+"The game will begin in "+time+" seconds.");
							}
						}
					}
				}
				
			}, 1000, 1);
		}
	}
}
