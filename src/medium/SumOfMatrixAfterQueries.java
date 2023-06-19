package medium;

import java.util.HashSet;
import java.util.Set;

public class SumOfMatrixAfterQueries {
	
	public static void main(String[] args) {
		long res = matrixSumQueries(8, new int[][]{{0, 6, 30094},
				{0, 7, 99382},
				{1, 2, 18599},
				{1, 3, 49292},
				{1, 0, 81549},
				{1, 1, 38280},
				{0, 0, 19405},
				{0, 4, 30065},
				{1, 4, 60826},
				{1, 5, 9241},
				{0, 5, 33729},
				{0, 1, 41456},
				{0, 2, 62692},
				{0, 3, 30807},
				{1, 7, 70613},
				{1, 6, 9506},
				{0, 5, 39344},
				{1, 0, 44658},
				{1, 1, 56485},
				{1, 2, 48112},
				{0, 6, 43384}});
		System.out.println(res);
	}
	
	/**
	 * 44658 56485 48112 0 0 0 0 0
	 * 44658 56485 48112 0 0 0 0 0
	 * 44658 56485 48112 0 0 0 0 0
	 * 44658 56485 48112 0 0 0 0 0
	 * 44658 56485 48112 0 0 0 0 0
	 * 43384 43384 43384 43384 43384 43384 43384 43384
	 * 44658 56485 48112 0 0 0 0 0
	 * 44658 56485 48112 0 0 0 0 0
	 */
	
	
	public static long matrixSumQueries(int n, int[][] queries) {
		long res = 0;
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		for (int i = queries.length - 1; i >= 0; i--) {
			int[] query = queries[i];
			int type = query[0], j = query[1], val = query[2];
			if (type == 0 && !rows.contains(j)) {
				res += ((long) val * (n - cols.size()));
				rows.add(j);
			}
			if (type == 1 && !cols.contains(j)) {
				res += ((long) val * (n - rows.size()));
				cols.add(j);
			}
		}
		return res;
	}
	
}
