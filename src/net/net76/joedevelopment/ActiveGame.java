package net.net76.joedevelopment;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ActiveGame {
	private static int status = 1;
	private static boolean hasStartedBefore = false;
	private static int timer = 0;
	public static void nogame(Player caller) {
		caller.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"Game is being stopped.");
		if(status == GameStatus.NOT_ACTIVE) {
			caller.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"No game is active. Return code was 1 (NOT_ACTIVE)");
		} else if(status == GameStatus.NO_GAME) {
			caller.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"No game is active. Return code was 0 (NO_GAME)");
		}
		else {
			status = GameStatus.NO_GAME;
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"ATTENTION: The game has been stopped by an admin!");
			Object[] players = Bukkit.getServer().getOnlinePlayers().toArray();
			for(int i=0;i<players.length;i++) {
				((Player)players[i]).chat("/spawn");
			}
		}
	}
	public static void startGame() {
		if(!hasStartedBefore) {
			Timer t = new Timer();
			timer = 0;
			status = GameStatus.GAME_STARTING;
			t.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					if(status == GameStatus.GAME_STARTING) {
						if(Team1.length() == 3 && Team2.length() == 3) {
							int timeleft = 35-timer;
							if(timeleft == 0) {
								status = GameStatus.GAME_ACTIVE;
								Team1.sendToSpawn();
								Team2.sendToSpawn();
								Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.GREEN+"The game has started.");
							} else {
								Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.GREEN+"The game starts in "+timeleft+" seconds.");
							}
						} else {
							status = GameStatus.NOT_ACTIVE;
						}
					}
				}
				
			}, 1000, 1);
		} else {
			timer = 0;
			status = GameStatus.GAME_STARTING;
		}
	}
}
