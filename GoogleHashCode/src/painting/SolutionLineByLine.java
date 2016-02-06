package painting;

import java.util.ArrayList;
import java.util.List;

public class SolutionLineByLine extends Solution {

	public SolutionLineByLine(List<String> grid) {
		super(grid);
	}

	@Override
	public List<String> solve() {
		List<String> ans = new ArrayList<String>();
		int row = 0;
		for (String s : this.getGrid()) {
			int startColumn = -1;
			int curColumn = 0;
			for (Character c : s.toCharArray()) {
				if (startColumn != -1 && c == '.') {
					ans.add("PAINT_LINE " + row + " " + startColumn + " " + row + " " + (curColumn-1));
					startColumn = -1;
				} else if (startColumn == -1 && c == '#') {
					startColumn = curColumn;
				}
				curColumn++;
			}
			row++;
		}
		return ans;
	}
}
