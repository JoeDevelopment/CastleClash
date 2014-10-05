package net.net76.joedevelopment;

import java.util.ArrayList;

public class ShopKeeper {
	private static ArrayList<Integer> x = new ArrayList<Integer>();
	private static ArrayList<Integer> y = new ArrayList<Integer>();
	private static ArrayList<Integer> z = new ArrayList<Integer>();
	public static void addToList(int xcoord, int ycoord, int zcoord) {
		x.add(xcoord);
		y.add(ycoord);
		z.add(zcoord);
	}
	public static Integer[] get(int index) {
		return new Integer[]{x.get(index),y.get(index),z.get(index)};
	}
	public static int length() {
		return x.toArray().length;
	}
	public static void remove(int xcoord,int ycoord, int zcoord) {
		x.remove(xcoord);
		y.remove(ycoord);
		z.remove(zcoord);
	}
	public static boolean contains(int xcoord,int ycoord, int zcoord) {
		if(x.contains(xcoord) && y.contains(ycoord) && z.contains(zcoord)) {
			return true;
		}
		return false;
	}
}
