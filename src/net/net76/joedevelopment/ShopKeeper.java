package net.net76.joedevelopment;

import java.util.ArrayList;

import org.bukkit.Bukkit;

public class ShopKeeper {
	private static ArrayList<String> x = new ArrayList<String>();
	private static ArrayList<String> y = new ArrayList<String>();
	private static ArrayList<String> z = new ArrayList<String>();
	public static void addToList(int xcoord, int ycoord, int zcoord) {
		x.add(""+xcoord);
		y.add(""+ycoord);
		z.add(""+zcoord);
	}
	public static Integer[] get(int index) {
		return new Integer[]{Integer.parseInt(x.get(index)),Integer.parseInt(y.get(index)),Integer.parseInt(z.get(index))};
	}
	public static int length() {
		return x.toArray().length;
	}
	public static void remove(int xcoord,int ycoord, int zcoord) {
		x.remove(""+xcoord);
		y.remove(""+ycoord);
		z.remove(""+zcoord);
	}
	public static boolean contains(int xcoord,int ycoord, int zcoord) {
		if(x.contains(""+xcoord) && y.contains(""+ycoord) && z.contains(""+zcoord)) {
			return true;
		}
		return false;
	}
	public static Object[] getX() {
		return x.toArray();
	}
	public static Object[] getY() {
		return y.toArray();
	}
	public static Object[] getZ() {
		return z.toArray();
	}
	public static void removeALL() {
		for(int i=0;i<x.toArray().length;i++) {
			x.remove(i);
			y.remove(i);
			z.remove(i);
		}
	}
}
