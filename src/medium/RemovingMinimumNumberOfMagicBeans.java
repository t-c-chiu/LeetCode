package medium;

import java.util.Arrays;

public class RemovingMinimumNumberOfMagicBeans {
	
	public static void main(String[] args) {
		long res = minimumRemoval(new int[]{4, 1, 6, 5});
		System.out.println(res);
	}
	
	public static long minimumRemoval(int[] beans) {
		long n = beans.length, res = Long.MAX_VALUE, sum = 0;
		for (int bean : beans) {
			sum += bean;
		}
		Arrays.sort(beans);
		for (int i = 0; i < n; i++) {
			res = Math.min(res, sum - (n - i) * beans[i]);
		}
		return res;
	}
//	public static long minimumRemoval(int[] beans) {
//		long sum = 0;
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for (int bean : beans) {
//			map.put(bean, map.getOrDefault(bean, 0) + 1);
//			sum += bean;
//		}
//		long res = Long.MAX_VALUE;
//		int count = beans.length;
//		while (!map.isEmpty()) {
//			Map.Entry<Integer, Integer> firstEntry = map.pollFirstEntry();
//			int min = firstEntry.getKey(), minCount = firstEntry.getValue();
//			res = Math.min(res, sum - ((long) min * count));
//			count -= minCount;
//		}
//		return res;
//	}
}
