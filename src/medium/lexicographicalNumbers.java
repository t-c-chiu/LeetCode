package medium;

import java.util.ArrayList;
import java.util.List;

public class lexicographicalNumbers {
	
	public static void main(String[] args) {
		List<Integer> res = lexicalOrder(13);
		System.out.println(res);
	}
	
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		int cur = 1;
		for (int i = 1; i <= n; i++) {
			res.add(cur);
			if (cur * 10 <= n) {
				cur *= 10;
			} else {
				while (cur % 10 == 9 || cur == n) {
					cur /= 10;
				}
				cur++;
			}
		}
		return res;
	}

//	public static List<Integer> lexicalOrder(int n) {
//		List<Integer> res = new ArrayList<>();
//		for (int i = 1; i <= 9; i++) {
//			dfs(res, i, n);
//		}
//		return res;
//	}
//
//	private static void dfs(List<Integer> res, int i, int n) {
//		if (i > n) {
//			return;
//		}
//		res.add(i);
//		for (int j = 0; j <= 9; j++) {
//			int next = i * 10 + j;
//			if (next > n) {
//				return;
//			}
//			dfs(res, next, n);
//		}
//	}
}
