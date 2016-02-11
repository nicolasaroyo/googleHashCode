package drones;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;

public class Order {
	
	private Coord location;
	private int nbProducts;
	private List<Integer> products = new ArrayList<Integer>();

	public Order(String coords, String nbProducts, String listProducts) {
		this.location = new Coord(Integer.parseInt(coords.split(" ")[0]), Integer.parseInt(coords.split(" ")[1]));
		this.nbProducts = Integer.parseInt(nbProducts);
		for (String s : listProducts.split(" ")) {
			products.add(Integer.parseInt(s));
		}
	}

}
