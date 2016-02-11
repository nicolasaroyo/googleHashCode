package drones;

import java.util.List;

public class SolutionClosestWarehouse {
	
	public void solve(Problem problem){
		List<Order> orders = problem.getOrders();
		List<Warehouse> warehouses = problem.getWarehouses();
		List<Drone> drones = problem.getDrones();
		for(Order order : orders){
			Warehouse closestWarehouse =  findClosestWarehouse(order, warehouses);
			Drone closestDrone = findClosestDrone(closestWarehouse, drones); 
			
		}
		
		
	}

	private Drone findClosestDrone(Warehouse closestWarehouse, List<Drone> drones) {
		// TODO Auto-generated method stub
		return null;
	}

	private Warehouse findClosestWarehouse(Order order, List<Warehouse> warehouses) {
		Warehouse result = null;
		
		return result;		
	}

}
