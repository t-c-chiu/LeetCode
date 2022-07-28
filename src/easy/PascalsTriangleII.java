package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	
	public static void main(String[] args) {
		List<Integer> res = getRow(5);
		System.out.println(res);
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for (int i = 0; i < rowIndex; i++) {
			res.add(1);
			for (int j = i; j >= 1; j--) {
				res.set(j, res.get(j) + res.get(j - 1));
			}
		}
		return res;
	}
}
