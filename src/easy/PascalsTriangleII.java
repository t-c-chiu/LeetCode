package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
	
	public static void main(String[] args) {
		List<Integer> res = getRow(5);
		System.out.println(res);
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = List.of(1);
		int i = 0;
		while (i < rowIndex) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			for (int j = 0; j < res.size() - 1; j++) {
				temp.add(res.get(j) + res.get(j + 1));
			}
			temp.add(1);
			res = temp;
			i++;
		}
		return res;
	}
}
