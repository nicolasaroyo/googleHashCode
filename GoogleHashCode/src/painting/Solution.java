package painting;

import java.util.List;

public abstract class Solution {
	
	private List<String> grid;
	
	public Solution(List<String> grid) {
		this.grid = grid;
		this.grid.remove(0);
	}
	
	public abstract List<String> solve();
	
	public List<String> getGrid() {
		return this.grid;
	}
	
}
