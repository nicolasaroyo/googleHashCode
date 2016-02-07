package painting;

import java.util.ArrayList;
import java.util.List;

import utils.Coord;
import utils.FileManager;

public class Main {
	
	private static void writeSolution(List<String> solution) {
		List<String> size = new ArrayList<String>();
		size.add(Integer.toString(solution.size()));
		FileManager.write(size, "output.ou");
		FileManager.write(solution, "output.ou", false);
	}
	
	public static void main(String[] args) {
		List<String> grid = FileManager.read("input3.in");
		int nbRow = Integer.parseInt(grid.get(0).split(" ")[0]);
		int nbColumn = Integer.parseInt(grid.get(0).split(" ")[1]);
		List<List<Coord>> forms = new FormsFinder(grid).findForms();
		
		List<String> ans = new ArrayList<String>();
		for (List<Coord> form : forms) {
			List<String> curGrid = formToGrid(form, nbRow, nbColumn);
			List<List<String>> solutions = new ArrayList<List<String>>();
			
			// Add new solutions here
			solutions.add(new SolutionLineByLine(curGrid).solve());
			solutions.add(new SolutionColumnByColumn(curGrid).solve());
			
			int minSize = Integer.MAX_VALUE;
			List<String> bestSolution = null;
			for (List<String> solution : solutions) {
				if (solution.size() < minSize) {
					minSize = solution.size();
					bestSolution = solution;
				}
			}
			ans.addAll(bestSolution);
		}
		
		writeSolution(ans);
		System.out.println("Done");
	}

	private static List<String> formToGrid(List<Coord> form, int nbRow, int nbColumn) {
		List<String> grid = new ArrayList<String>();
		grid.add(nbRow + " " + nbColumn);
		for (int row = 0 ; row < nbRow ; row++) {
			StringBuilder line = new StringBuilder();
			for (int column = 0 ; column < nbColumn ; column++) {
				line.append(form.contains(new Coord(row, column)) ? "#" : ".");
			}
			grid.add(line.toString());
		}
		return grid;
	}
}
