package drones;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;

public class Drone {
	
	private int id;
	private int load;
	private Coord position;
	private List<Integer> products = new ArrayList<Integer>();
	
	public Drone(){
	}
	
	public Drone(int id, int load, Coord position) {
		this.id = id;
		this.load = load;
		this.position = position;
	}
	public Drone(Drone d) {
		this.id = d.id;
		this.load = d.load;
		this.position = new Coord(d.position);
		for (Integer i : d.products) {
			this.products.add(i);
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoad() {
		return load;
	}
	public void setLoad(int load) {
		this.load = load;
	}
	public Coord getPosition() {
		return position;
	}
	public void setPosition(Coord position) {
		this.position = position;
	}

	public List<Integer> getProducts() {
		return products;
	}
}
