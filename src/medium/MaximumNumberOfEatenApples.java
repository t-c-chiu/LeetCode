package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEatenApples {
	
	public static void main(String[] args) {
		int res = eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
		System.out.println(res);
	}
	
	public static int eatenApples(int[] apples, int[] days) {
		int res = 0, n = apples.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < n || !pq.isEmpty(); i++) {
			if (i < n) {
				pq.offer(new int[]{i + days[i], apples[i]});
			}
			while (!pq.isEmpty() && pq.peek()[0] <= i) {
				pq.poll();
			}
			if (!pq.isEmpty()) {
				res++;
				if (--pq.peek()[1] == 0) {
					pq.poll();
				}
			}
		}
		return res;
	}
}
