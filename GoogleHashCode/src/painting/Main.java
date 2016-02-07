package painting;

import java.util.ArrayList;
import java.util.List;

import dataCenter.Coord;

public class Main {
	
	private static void writeSolution(List<String> solution) {
		List<String> size = new ArrayList<String>();
		size.add(Integer.toString(solution.size()));
		FileManager.write(size, "output.ou");
		FileManager.write(solution, "output.ou", false);
	}
	
	public static void main(String[] args) {
		List<String> grid = FileManager.read("input3.in");
		Solution solution1 = new SolutionLineByLine(grid);
		List<String> ans1 = solution1.solve();
		Solution solution2 = new SolutionColumnByColumn(grid);
		List<String> ans2 = solution2.solve();
		
		writeSolution(ans1.size() < ans2.size() ? ans1 : ans2);
		
		System.out.println((ans1.size() < ans2.size() ? "Ligne par ligne" : "Colonne par colonne") + " : " + ans1.size() + " / " + ans2.size());
	
		
		FormsFinder ff = new FormsFinder(grid);
		List<List<Coord>> forms = ff.findForms();
		System.out.println("Number of Forms = "+forms.size());
	/**	for(List<Coord> f : forms){
			System.out.println(f.size());
			for(Coord coord : f){
				System.out.println(coord.getRow()+ " "+coord.getColumn());
			}
			System.out.println("===========");
		}
		*/
	}
}
