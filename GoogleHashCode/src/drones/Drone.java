package drones;

import utils.Coord;

public class Drone {
	
	private int id;
	private int load;
	private Coord position;
	
	public Drone(){
		
		
	}
	
	public Drone(int id, int load, Coord position) {
		this.id = id;
		this.load = load;
		this.position = position;
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
	
	

}
