package dataCenter;

public class Server {
	private int size;
	private int capacity;
	
	private int row;
	private int slot;
	private int pool;
	
	public Server(int size, int capacity) {
		this.size = size;
		this.capacity = capacity;
	}
	
	public Server() {
	}

	public int getSize() {
		return size;
	}
	public int getCapacity() {
		return capacity;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public int getPool() {
		return pool;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}
}
