package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumAmountOfTimeToFillCups {
	
	public static void main(String[] args) {
		int res = fillCups(new int[]{5, 4, 4});
		System.out.println(res);
	}
	
	public static int fillCups(int[] amount) {
		Arrays.sort(amount);
		if (amount[0] + amount[1] <= amount[2]) {
			return amount[2];
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i : amount) {
			if (i > 0) {
				q.offer(i);
			}
		}
		int res = 0;
		while (q.size() > 1) {
			Integer cup1 = q.poll();
			Integer cup2 = q.poll();
			if (cup1 > 1) {
				q.offer(cup1 - 1);
			}
			if (cup2 > 1) {
				q.offer(cup2 - 1);
			}
			res++;
		}
		return res + (q.isEmpty() ? 0 : q.poll());
	}
}
