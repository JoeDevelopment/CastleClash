package net.net76.joedevelopment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataDecoder {
	public static void DecodeAndInsert() {
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
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(ff));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data = "";
		String current = "";
		try {
			while((current = r.readLine()) != null) {
				if(data.equalsIgnoreCase("")) {
					data = current;
				} else {
					data = data+"\n"+current;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!data.split("\n")[0].equalsIgnoreCase("")) {
		String[] newdata = data.split("\n");
		String[] coords = newdata[0].split(",");
		for(int i=0;i<coords.length;i++) {
			int x = 0;
			int y = 0;
			int z = 0;
			String[] ind = coords[i].split("12345678900987654321");
			x = Integer.parseInt(ind[0]);
			y = Integer.parseInt(ind[1]);
			z = Integer.parseInt(ind[2]);
			ShopKeeper.addToList(x, y, z);
		}
		if(newdata[1].split(",").length == 2) {
			String[] coords1 = newdata[1].split(",")[0].split("12345678900987654321");
			Team1.setSpawn(Integer.parseInt(coords1[0]), Integer.parseInt(coords1[1]), Integer.parseInt(coords1[2]));
			String[] coords2 = newdata[1].split(",")[1].split("12345678900987654321");
			Team1.setSpawn(Integer.parseInt(coords2[0]), Integer.parseInt(coords2[1]), Integer.parseInt(coords2[2]));
		}
		}
		try {
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
