package net.net76.joedevelopment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class DataEncoder {
	public static void Encode() {
		File f = new File("plugins/CastleClash");
		if(!f.exists()) {
			f.mkdir();
		}
		File ff = new File("plugins/CastleClash/.data");
		if(!ff.exists()) {
			try {
				ff.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PrintWriter w = null;
		try {
			w = new PrintWriter(ff);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] x = ShopKeeper.getX();
		Object[] y = ShopKeeper.getY();
		Object[] z = ShopKeeper.getZ();
		String data = "";
		for(int i=0;i<x.length;i++) {
			String finall = x[i]+"12345678900987654321"+y[i]+"12345678900987654321"+z[i]+"";
			if(data.equalsIgnoreCase("")) {
				data = finall;
			} else {
				data = data+","+finall;
			}
		}
		data = data+"\n";
		data = data+Team1.getSpawn()[0]+"12345678900987654321"+Team1.getSpawn()[1]+"12345678900987654321"+Team1.getSpawn()[2];
		data = data+","+Team2.getSpawn()[0]+"12345678900987654321"+Team2.getSpawn()[1]+"12345678900987654321"+Team2.getSpawn()[2];
		w.println(data);
		w.close();
	}
}
