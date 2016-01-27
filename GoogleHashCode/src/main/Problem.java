package main;


import java.util.ArrayList;
import java.util.List;

public class Problem {
	private static final String UNALLOCATED_SERVER = "x";
	private static final String SPACE = " ";
	private int nbRows;
	private int nbSlotsPerRow;
	private List<Coord> unavailableSlot;
	private int nbPools;
	private	List<Server> servers;
	
	public Problem(){
		unavailableSlot = new ArrayList<Coord>();
		servers = new ArrayList<Server>();
		
	}
	
	public void initialize() {
		// TODO Auto-generated method stub
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
		FileManager fileManager = new FileManager();
		List<String> textOutput = new ArrayList<String>();
		for (Server server: servers){
			//TODO find the condition for an unalocated server 
			if (server.getSlot() == -1){
				textOutput.add(UNALLOCATED_SERVER);
			} else {
				StringBuilder line = new StringBuilder();
				//the allocated row(ar as ​i) and slot within the row(i) for the server, and the allocated logical pool for it (a pi ); 
				line.append(server.getRow()).append(SPACE).append(server.getSlot()).append(SPACE).append(server.getPool());
				textOutput.add(line.toString());				
			}			
		}
		fileManager.write(textOutput);
	}
}
