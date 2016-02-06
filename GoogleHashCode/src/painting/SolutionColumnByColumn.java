package painting;

import java.util.ArrayList;
import java.util.List;

public class SolutionColumnByColumn extends Solution {

	public SolutionColumnByColumn(List<String> grid) {
		super(grid);
	}

	@Override
	public List<String> solve() {
		List<String> newGrid = new ArrayList<String>();

		int rowSize = this.getGrid().get(0).length();
		
		for (int column = 0 ; column < rowSize ; column++) {
			StringBuilder sb = new StringBuilder();
			for (String s : this.getGrid()) {
				sb.append(s.charAt(column));
			}
			newGrid.add(sb.toString());
		}
		
		List<String> ans = new ArrayList<String>();
		int row = 0;
		for (String s : newGrid) {
			int startColumn = -1;
			int curColumn = 0;
			for (Character c : s.toCharArray()) {
				if (startColumn != -1 && c == '.') {
					ans.add("PAINT_LINE " + startColumn + " " + row + " " + (curColumn-1) + " " + row);
					startColumn = -1;
				} else if (startColumn == -1 && c == '#') {
					startColumn = curColumn;
				}
				curColumn++;
			}
			if (startColumn != -1) {
				ans.add("PAINT_LINE " + startColumn + " " + row + " " + (curColumn-1) + " " + row);
			}
			row++;
		}
		return ans;
	}

}
