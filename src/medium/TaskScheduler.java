package medium;

import java.util.*;

public class TaskScheduler {
	
	public static void main(String[] args) {
		int res = leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
		System.out.println(res);
	}
	
	public static int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for (char task : tasks) {
			count[task - 'A']++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i : count) {
			if (i > 0) {
				pq.offer(i);
			}
		}
		int res = 0;
		while (!pq.isEmpty()) {
			int k = n + 1;
			List<Integer> nextTasks = new ArrayList<>();
			while (!pq.isEmpty() && k > 0) {
				int i = pq.poll();
				if (--i > 0) {
					nextTasks.add(i);
				}
				res++;
				k--;
			}
			if (!nextTasks.isEmpty()) {
				pq.addAll(nextTasks);
				res += k;
			}
		}
		return res;
	}
}
