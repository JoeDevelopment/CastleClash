package net.net76.joedevelopment;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Team1 {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static int xspawn = 0;
	private static int yspawn = 0;
	private static int zspawn = 0;
	
	public static boolean inTeam(Player p) {
		if(players.contains(p)) {
			return true;
		}
		return false;
	}
	public static boolean addPlayer(Player p) {
		if(players.toArray().length >=3 || Team1.contains(p) || Team2.contains(p)) {
			return false;
		} else {
			players.add(p);
			return true;
		}
	}
	public static void removePlayer(Player p) {
		players.remove(p);
	}
	public static void setSpawn(int x, int y, int z) {
		xspawn = x;
		yspawn = y;
		zspawn = z;
	}
	public static void sendToSpawn() {
		for(int i=0;i<players.toArray().length;i++) {
			players.get(i).teleport(new Location(Bukkit.getServer().getWorld("Map1"),xspawn,yspawn,zspawn));
		}
	}
	public static boolean contains(Player p) {
		return players.contains(p);
	}
	public static Integer[] getSpawn() {
		return new Integer[]{xspawn,yspawn,zspawn};
	}
}
