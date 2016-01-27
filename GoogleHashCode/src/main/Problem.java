package main;


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
		List<String> lines = FileManager.read();
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
		createDummyServers();
		
	}
	
	//FIXME remove later after testing of output
	private void createDummyServers(){
		Server server1 = new Server();
		server1.setPool(1);
		server1.setRow(100);
		server1.setSlot(23);
		this.servers.add(server1);
		Server server2 = new Server();
		server2.setPool(1);
		server2.setRow(100);
		server2.setSlot(-1);
		this.servers.add(server2);
		
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
		FileManager.write(textOutput);
	}
}

