package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {
	
	public static void main(String[] args) {
		int res = numFactoredBinaryTrees(new int[]{2, 4, 5, 10});
		System.out.println(res);
	}
	
	public static int numFactoredBinaryTrees(int[] arr) {
		Arrays.sort(arr);
		Map<Integer, Long> map = new HashMap<>();
		int n = arr.length, mod = (int) (1e9 + 7);
		long res = 0;
		for (int i = 0; i < n; i++) {
			int root = arr[i];
			map.put(root, 1L);
			for (int j = 0; j < i; j++) {
				int left = arr[j];
				if (root % left == 0) {
					int right = root / left;
					map.put(root, map.get(root) + map.getOrDefault(left, 0L) * map.getOrDefault(right, 0L));
				}
			}
			res = (res + map.get(root)) % mod;
		}
		return (int) res;
	}
}
