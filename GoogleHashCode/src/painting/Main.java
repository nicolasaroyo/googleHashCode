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
		List<String> grid = FileManager.read("input.in");
		
		Solution solution1 = new SolutionLineByLine(grid);
		List<String> ans1 = solution1.solve();
		Solution solution2 = new SolutionColumnByColumn(grid);
		List<String> ans2 = solution2.solve();
		
		writeSolution(ans1.size() < ans2.size() ? ans1 : ans2);
		
		System.out.println((ans1.size() < ans2.size() ? "Ligne par ligne" : "Colonne par colonne") + " : " + ans1.size() + " / " + ans2.size());
	}
}
