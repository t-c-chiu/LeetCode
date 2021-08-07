package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
	
	public static void main(String[] args) {
		int res = maxEvents(new int[][]{
				{1, 5},
				{1, 5},
				{1, 5},
				{2, 3},
				{2, 3},
		});
		System.out.println(res);
	}
	
	public static int maxEvents(int[][] events) {
		Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int res = 0;
		int i = 0;
		for (int day = 1; day <= 100000; day++) {
			while (i < events.length && events[i][0] == day) {
				queue.offer(events[i++][1]);
			}
			while (!queue.isEmpty() && queue.peek() < day) {
				queue.poll();
			}
			if (!queue.isEmpty()) {
				res++;
				queue.poll();
			}
		}
		return res;
	}
}
