package painting;

import java.util.ArrayList;
import java.util.List;


public class FormsFinder {
	
	private List<String> grid;
	private int rows;
	private int cols;
	
	public FormsFinder(List<String> grid) {
		this.grid = new ArrayList<String>(grid);
	
		this.grid.remove(0);
		this.rows = this.grid.size();
		this.cols = this.grid.get(0).length();
	}
	
	
	
	public List<List<Coord>> findForms(){
		List<List<Coord>> forms = new ArrayList<List<Coord>>();
		boolean[][] visited = new boolean[rows][cols];
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				if (grid.get(r).charAt(c) == '#'){
					List<Coord> form= new ArrayList<Coord>();
					int size = findForms(r, c, visited, form);
					if (size > 0){
						forms.add(form);
					}
				}
			}
			
		}
		return forms;
	}
	
	
	private int findForms(int row, int col, boolean[][] visited, List<Coord> form ){
		if (row < 0 || col < 0 || row >= rows || col >= cols ||	visited[row][col]){
			return 0;
		} else if ( grid.get(row).charAt(col) == '.'){
			visited[row][col] = true;
			return 0;
		}
		int size = 1; 
		visited[row][col] = true;
		form.add(new Coord(row, col));
		
		size += findForms(row+1, col, visited, form);
		size += findForms(row-1, col, visited, form);
		size += findForms(row, col-1, visited, form);
		size += findForms(row, col+1, visited, form);
		return size;
				
	}	
	

	
}
