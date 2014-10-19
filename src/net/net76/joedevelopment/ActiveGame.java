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
		} else {
			status = GameStatus.NO_GAME;
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"ATTENTION: The game has been stopped by an admin!");
		}
	}
	public static void startGame() {
		if(!hasStartedBefore) {
			Timer t = new Timer();
			timer = 0;
			t.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					if(status == GameStatus.GAME_STARTING) {
						
					}
				}
				
			}, 1000, 1);
		}
	}
}
