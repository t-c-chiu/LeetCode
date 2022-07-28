package medium;

import java.util.HashMap;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
	
	public static void main(String[] args) {
		int res = findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3);
		System.out.println(res);
	}
	
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int n = arr.length;
		int[] freqCount = new int[n + 1];
		for (Integer freq : map.values()) {
			freqCount[freq]++;
		}
		int res = map.size();
		for (int i = 1; i <= n; i++) {
			if (freqCount[i] == 0) {
				continue;
			}
			if (k >= i * freqCount[i]) {
				k -= i * freqCount[i];
				res -= freqCount[i];
			} else {
				res -= k / i;
				break;
			}
		}
		return res;
	}
//	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i : arr) {
//			map.put(i, map.getOrDefault(i, 0) + 1);
//		}
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.addAll(map.values());
//		while (!pq.isEmpty() && k > 0) {
//			Integer leastFreq = pq.peek();
//			if (leastFreq > k) {
//				break;
//			}
//			pq.poll();
//			k -= leastFreq;
//		}
//		return pq.size();
//	}
}
