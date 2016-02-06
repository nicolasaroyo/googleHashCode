package painting;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static void writeSolution(List<String> solution) {
		List<String> size = new ArrayList<String>();
		size.add(Integer.toString(solution.size()));
		FileManager.write(size, "output.ou", true);
		FileManager.write(solution, "output.ou", false);
	}
	
	public static void main(String[] args) {
		List<String> grid = FileManager.read("input3.in");
		
		Solution solution = new SolutionCellByCell(grid);
		writeSolution(solution.solve());
		
		System.out.println("Done");
	}
}
