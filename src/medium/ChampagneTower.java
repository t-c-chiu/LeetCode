package medium;

import java.util.ArrayList;
import java.util.List;

public class ChampagneTower {
	
	public static void main(String[] args) {
		double res = champagneTower(6, 3, 0);
		System.out.println(res);
	}
	
	public static double champagneTower(int poured, int query_row, int query_glass) {
		List<Double> prevRow = new ArrayList<>();
		prevRow.add((double) poured);
		for (int i = 1; i <= query_row; i++) {
			List<Double> curRow = new ArrayList<>();
			double sideGlass = Math.max(0, (prevRow.get(0) - 1) / 2);
			curRow.add(sideGlass);
			for (int j = 1; j < prevRow.size(); j++) {
				curRow.add(Math.max(0, (prevRow.get(j - 1) - 1) / 2) + Math.max(0, (prevRow.get(j) - 1) / 2));
			}
			curRow.add(sideGlass);
			prevRow = curRow;
		}
		
		return Math.min(1, prevRow.get(query_glass));
	}
}
