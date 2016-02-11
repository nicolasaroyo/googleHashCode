package drones;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;

public class Warehouse {
	
	private Coord location;
	private List<Integer> productQuantity = new ArrayList<Integer>();
	private int id;

	public Warehouse(String coords, String products, int id) {
		this.location = new Coord(Integer.parseInt(coords.split(" ")[0]), Integer.parseInt(coords.split(" ")[1]));
		this.id = id;
		for (String s : products.split(" ")) {
			this.productQuantity.add(Integer.parseInt(s));
		}
	}

	public Warehouse(Warehouse w) {
		this.location = new Coord(w.location);
		this.id = w.id;
		for (Integer i : w.productQuantity) {
			this.productQuantity.add(i);
		}
	}

	public List<Integer> getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(List<Integer> productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Coord getLocation() {
		return location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
