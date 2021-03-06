package drones;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;

public class Order {
	
	private Coord location;
	private int nbProducts;
	private List<Integer> products = new ArrayList<Integer>();
	private int id;

	public Order(String coords, String nbProductsWanted, String listProducts, int nbProducts, int id) {
		this.location = new Coord(Integer.parseInt(coords.split(" ")[0]), Integer.parseInt(coords.split(" ")[1]));
		this.nbProducts = Integer.parseInt(nbProductsWanted);
		for (int i = 0 ; i < nbProducts ; i++) {
			this.products.add(0);
		}
		
		for (String s : listProducts.split(" ")) {
			int productWanted = Integer.parseInt(s);
			this.products.set(productWanted, 1+this.products.get(productWanted));
		}
		this.id = id;
	}

	public Order(Order o) {
		this.location = new Coord(o.location);
		this.nbProducts = o.nbProducts;
		this.id = o.id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
