package drones;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;

public class Warehouse {
	
	private Coord location;
	private List<Integer> productQuantity = new ArrayList<Integer>();

	public Warehouse(String coords, String products) {
		this.location = new Coord(Integer.parseInt(coords.split(" ")[0]), Integer.parseInt(coords.split(" ")[1]));
		for (String s : products.split(" ")) {
			this.productQuantity.add(Integer.parseInt(s));
		}
	}

}
