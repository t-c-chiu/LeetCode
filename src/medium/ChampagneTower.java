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
			List<Double> row = new ArrayList<>();
			double side = Math.max(0, (prevRow.get(0) - 1) / 2);
			row.add(side);
			for (int j = 1; j < prevRow.size(); j++) {
				double prevLeft = Math.max(0, (prevRow.get(j - 1) - 1) / 2), prevRight = Math.max(0, (prevRow.get(j) - 1) / 2);
				row.add(prevLeft + prevRight);
			}
			row.add(side);
			prevRow = row;
		}
		return Math.min(1, prevRow.get(query_glass));
	}
}
