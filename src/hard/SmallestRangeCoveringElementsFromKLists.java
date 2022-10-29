package hard;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
	
	public static void main(String[] args) {
		int[] res = smallestRange(Arrays.asList(
				Arrays.asList(4, 10, 15, 24, 26),
				Arrays.asList(0, 9, 12, 20),
				Arrays.asList(5, 18, 22, 30)
		));
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		int start = -100000, end = 100000, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			Integer num = nums.get(i).get(0);
			pq.offer(new int[]{i, 0, num});
			max = Math.max(max, num);
		}
		while (pq.size() == nums.size()) {
			int[] poll = pq.poll();
			int i = poll[0], j = poll[1], num = poll[2];
			if (max - num < end - start) {
				start = num;
				end = max;
			}
			if (j + 1 < nums.get(i).size()) {
				Integer next = nums.get(i).get(j + 1);
				max = Math.max(max, next);
				pq.offer(new int[]{i, j + 1, next});
			}
		}
		return new int[]{start, end};
	}
	
}
