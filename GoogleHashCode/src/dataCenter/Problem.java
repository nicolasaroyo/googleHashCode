package dataCenter;


import java.util.ArrayList;
import java.util.List;

public class Problem {
	private static final String UNALLOCATED_SERVER = "x";
	private static final String SPACE = " ";
	private int nbRows;
	private int nbSlotsPerRow;
	private List<Coord> unavailableSlots;
	private int nbPools;
	private	List<Server> servers;
	
	public Problem(){
		unavailableSlots = new ArrayList<Coord>();
		servers = new ArrayList<Server>();
		
	}
	
	private int getNthIntegerInLine(String line, int n) {
		return Integer.parseInt(line.split(" ")[n-1]);
	}
	
	public void initialize() {
		List<String> lines = FileManager.read("input.txt");
		this.nbRows = this.getNthIntegerInLine(lines.get(0), 1);
		this.nbSlotsPerRow = this.getNthIntegerInLine(lines.get(0), 2);
		int nbUnavailableSlots = this.getNthIntegerInLine(lines.get(0), 3);
		this.nbPools = this.getNthIntegerInLine(lines.get(0), 4);
		int nbServers = this.getNthIntegerInLine(lines.get(0), 5);
		lines.remove(0);
		
		for (int i = 0 ; i < nbUnavailableSlots ; i++) {
			int row = this.getNthIntegerInLine(lines.get(0), 1);
			int column = this.getNthIntegerInLine(lines.get(0), 2);
			this.unavailableSlots.add(new Coord(row, column));
			lines.remove(0);
		}
		
		for (int i = 0 ; i < nbServers ; i++) {
			int size = this.getNthIntegerInLine(lines.get(0), 1);
			int capacity = this.getNthIntegerInLine(lines.get(0), 2);
			this.servers.add(new Server(size, capacity));
			lines.remove(0);
		}
	}
	
	public void solve() {
		// TODO Auto-generated method stub
		solveExample();
		
	}
	
	//FIXME remove later after testing of output
	private void solveExample(){
		this.servers.get(0).setRow(0);
		this.servers.get(0).setSlot(1);
		this.servers.get(0).setPool(0);
		this.servers.get(1).setRow(1);
		this.servers.get(1).setSlot(0);
		this.servers.get(1).setPool(1);
		this.servers.get(2).setRow(1);
		this.servers.get(2).setSlot(3);
		this.servers.get(2).setPool(0);
		this.servers.get(3).setRow(0);
		this.servers.get(3).setSlot(4);
		this.servers.get(3).setPool(1);
		this.servers.get(4).setRow(-1);
		this.servers.get(4).setSlot(-1);
		this.servers.get(4).setPool(-1);
	}
	
	public void print() {
		List<String> textOutput = new ArrayList<String>();
		for (Server server: servers){
			//TODO find the condition for an unallocated server 
			if (server.getSlot() == -1){
				textOutput.add(UNALLOCATED_SERVER);
			} else {
				StringBuilder line = new StringBuilder();
				//the allocated row(ar as ​i) and slot within the row(i) for the server, and the allocated logical pool for it (a pi ); 
				line.append(server.getRow()).append(SPACE).append(server.getSlot()).append(SPACE).append(server.getPool());
				textOutput.add(line.toString());				
			}			
		}
		FileManager.write(textOutput, "output.txt", true);
		System.err.println(this.getScore());
	}
	
	private int getScore() {
		List<Integer> guaranteedCapacity = new ArrayList<Integer>();
		for (int i = 0 ; i < this.nbPools ; i++) {
			List<Integer> capacityPerRow = new ArrayList<Integer>();
			for (int j = 0 ; j < this.nbRows ; j++) {
				capacityPerRow.add(0);
			}
			for (Server s : this.servers) {
				if (s.getPool() == i) {
					capacityPerRow.set(s.getRow(), capacityPerRow.get(s.getRow()) + s.getCapacity());
				}
			}
			int max = 0, sum = 0;
			for (Integer n : capacityPerRow) {
				max = (max > n) ? max : n;
				sum += n;
			}
			guaranteedCapacity.add(sum - max);
		}
		int min = Integer.MAX_VALUE;
		for (Integer n : guaranteedCapacity) {
			min = (min < n) ? min : n;
		}
		return min;
	}
}

