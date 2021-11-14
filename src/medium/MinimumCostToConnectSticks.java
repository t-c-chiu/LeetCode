package medium;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
	
	public static void main(String[] args) {
		int res = connectSticks(new int[]{2});
		System.out.println(res);
	}
	
	public static int connectSticks(int[] sticks) {
		int res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int stick : sticks) {
			pq.offer(stick);
		}
		while (pq.size() > 1) {
			int cost = pq.poll() + pq.poll();
			res += cost;
			pq.offer(cost);
		}
		return res;
	}
}
