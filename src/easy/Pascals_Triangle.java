package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascals_Triangle {
	
	public static void main(String[] args) {
		Pascals_Triangle test = new Pascals_Triangle();
		System.out.println(test.generate(10));
	}
	
	//    [1],
	//   [1,1],
	//  [1,2,1],
	// [1,3,3,1],
	//[1,4,6,4,1]
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>(numRows);
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>(i + 1);
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					row.add(1);
				else {
					List<Integer> prevRow = result.get(i - 1);
					row.add(prevRow.get(j - 1) + prevRow.get(j));
				}
			}
			result.add(row);
		}
		return result;
	}
}
