package medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
	
	public static void main(String[] args) {
		int res = integerReplacement(8);
		System.out.println(res);
	}
	
	public static int integerReplacement(int n) {
		Map<Long, Integer> cache = new HashMap<>();
		cache.put(1L, 0);
		return helper(n, cache);
	}
	
	private static int helper(long n, Map<Long, Integer> cache) {
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		int res = 1;
		if (n % 2 == 0) {
			res += helper(n / 2, cache);
		} else {
			res += Math.min(helper(n - 1, cache), helper(n + 1, cache));
		}
		cache.put(n, res);
		return res;
	}
}
