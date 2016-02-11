package drones;

import java.util.ArrayList;
import java.util.List;

import utils.FileManager;

public class Main {
	private static final String INPUT = "input.in";
	private static final String OUTPUT = "output.ou";

	public static void main(String[] args) {
		Problem p = new Problem(INPUT);
		write(new SolutionClosestWarehouse(), p);
		
		System.out.println("Done");
	}

	private static void write(Solution solution, Problem p) {
		List<String> ans = solution.solve(new Problem(p));
		List<String> nbInstructions = new ArrayList<String>();
		nbInstructions.add(Integer.toString(ans.size()));
		FileManager.write(nbInstructions, OUTPUT);
		FileManager.write(ans, OUTPUT, false);
	}
}
