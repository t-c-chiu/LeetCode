package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	public static void main(String[] args) {
		List<Integer> res = grayCode(3);
		System.out.println(res);
	}
	
	/**
	 * 0 1
	 * 00 01 11 10
	 * 000 001 011 010 110 111 101 100
	 */
	public static List<Integer> grayCode(int n) {
		if (n == 1) {
			List<Integer> res = new ArrayList<>();
			res.add(0);
			res.add(1);
			return res;
		}
		
		List<Integer> res = grayCode(n - 1);
		int size = res.size();
		for (int i = size - 1; i >= 0; i--) {
			res.add(res.get(i) | 1 << n - 1);
		}
		return res;
	}
}
