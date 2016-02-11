package drones;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;
import utils.FileManager;

public class Problem {
	private int nbRows;
	private int nbColumns;
	
	private int nbMaxTurns;
	private int nbDrones;
	private int maxLoadDrone;
	private List<Drone> drones = new ArrayList<Drone>();
	private int nbProducts;
	private List<Integer> productWeights = new ArrayList<Integer>();
	
	private int nbWarehouses;
	private List<Warehouse> warehouses = new ArrayList<Warehouse>();
	
	private int nbCustomerOrders;
	private List<Order> orders = new ArrayList<Order>();
	
	public Problem(String fileName) {
		List<String> file = FileManager.read(fileName);
		
		String[] params = file.get(0).split(" ");
		this.nbRows = Integer.parseInt(params[0]);
		this.nbColumns = Integer.parseInt(params[1]);
		this.nbDrones = Integer.parseInt(params[2]);
		this.nbMaxTurns = Integer.parseInt(params[3]);
		this.maxLoadDrone = Integer.parseInt(params[4]);
		
	
		file.remove(0);
		
		this.nbProducts = Integer.parseInt(file.get(0));
		
		file.remove(0);
		
		for (String s : file.get(0).split(" ")) {
			this.productWeights.add(Integer.parseInt(s));
		}
		
		file.remove(0);
		
		this.nbWarehouses = Integer.parseInt(file.get(0));
		
		file.remove(0);
		
		for (int i = 0 ; i < this.nbWarehouses ; i++) {
			this.warehouses.add(new Warehouse(file.get(0), file.get(1)));
			file.remove(0); file.remove(0);
		}
		
		for(int i=0; i< this.nbDrones; i++){
			Drone toAdd = new Drone(i, this.maxLoadDrone, new Coord(this.warehouses.get(0).getLocation()));
			for (int j = 0 ; j < this.nbProducts ; j++) {
				toAdd.getProducts().add(0);
			}
			this.drones.add(toAdd);
		}
		
		
		this.nbCustomerOrders = Integer.parseInt(file.get(0));
		
		file.remove(0);
		
		for (int i = 0 ; i < this.nbCustomerOrders ; i++) {
			this.orders.add(new Order(file.get(0), file.get(1), file.get(2), this.nbProducts));
			file.remove(0); file.remove(0); file.remove(0);
		}
		
		
	}

	/**
	 * Clones the problem
	 * @param problem
	 */
	
	public Problem(Problem problem) {
		this.nbRows = problem.nbRows;
		this.nbColumns = problem.nbColumns;
		this.nbDrones = problem.nbDrones;
		this.nbMaxTurns = problem.nbMaxTurns;
		this.maxLoadDrone = problem.maxLoadDrone;
		this.nbProducts = problem.nbProducts;
		for (Integer i : problem.productWeights) {
			this.productWeights.add(i);
		}
		this.nbWarehouses = problem.nbWarehouses;
		for (Warehouse w : problem.warehouses) {
			this.warehouses.add(new Warehouse(w));
		}
		this.nbCustomerOrders = problem.nbCustomerOrders;
		for (Order o : problem.orders) {
			this.orders.add(new Order(o));
		}
		for(Drone d : problem.drones){
			this.drones.add(new Drone(d));
		}
	}

	public int getNbRows() {
		return nbRows;
	}

	public int getNbColumns() {
		return nbColumns;
	}

	public int getNbDrones() {
		return nbDrones;
	}

	public int getNbMaxTurns() {
		return nbMaxTurns;
	}

	public int getMaxLoadDrone() {
		return maxLoadDrone;
	}

	public int getNbProducts() {
		return nbProducts;
	}

	public List<Integer> getProductWeights() {
		return productWeights;
	}

	public int getNbWarehouses() {
		return nbWarehouses;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public int getNbCustomerOrders() {
		return nbCustomerOrders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}
}
