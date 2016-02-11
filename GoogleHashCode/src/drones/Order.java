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

	public Order(Order o) {
		this.location = new Coord(o.location);
		this.nbProducts = o.nbProducts;
		for (Integer i : o.products) {
			this.products.add(i);
		}
	}

	public Coord getLocation() {
		return location;
	}

	public int getNbProducts() {
		return nbProducts;
	}

	public List<Integer> getProducts() {
		return products;
	}
	
	public boolean isCompleted(){
		for(Integer product : this.products){
			if (product > 0) return false;
			
		}
		return true;
		
	}
}
