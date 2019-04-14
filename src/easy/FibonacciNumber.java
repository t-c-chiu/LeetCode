package easy;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
	
	public static void main(String[] args) {
		System.out.println(new FibonacciNumber().fib(5));
	}
	
	private Map<Integer, Integer> cache = new HashMap<>();
	
	// 0 1 1 2 3 5
	public int fib(int N) {
		cache.put(0, 0);
		cache.put(1, 1);
		return helper(N);
	}
	
	private int helper(int n) {
		if (cache.containsKey(n))
			return cache.get(n);
		
		int res = helper(n - 1) + helper(n - 2);
		cache.put(n, res);
		return res;
	}
}
