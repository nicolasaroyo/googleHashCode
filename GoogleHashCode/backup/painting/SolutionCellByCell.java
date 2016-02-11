package painting;

import java.util.ArrayList;
import java.util.List;

public class SolutionCellByCell extends Solution {

	public SolutionCellByCell(List<String> grid) {
		super(grid);
	}
	
	@Override
	public List<String> solve() {
		List<String> ans = new ArrayList<String>();
		int row = 0;
		for (String s : this.getGrid()) {
			int column = 0;
			for (Character c : s.toCharArray()) {
				if (c == '#') {
					ans.add("PAINT_LINE " + row + " " + column + " " + row + " " + column);
				}
				column++;
			}
			row++;
		}
		return ans;
	}
}
