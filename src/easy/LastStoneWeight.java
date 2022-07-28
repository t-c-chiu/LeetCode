package easy;

import java.util.*;

public class LastStoneWeight {
	
	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
	}
	
	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int stone : stones) {
			pq.offer(stone);
		}
		while (pq.size() > 1) {
			int big = pq.poll();
			int small = pq.poll();
			if (big > small) {
				pq.offer(big - small);
			}
		}
		return pq.isEmpty() ? 0 : pq.poll();
	}
}
