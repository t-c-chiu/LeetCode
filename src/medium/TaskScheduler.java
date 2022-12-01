package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
			while (k > 0 && !pq.isEmpty()) {
				int remain = pq.poll();
				if (--remain > 0) {
					nextTasks.add(remain);
				}
				res++;
				k--;
			}
			pq.addAll(nextTasks);
			if (pq.isEmpty()) {
				break;
			}
			res += k;
		}
		return res;
	}
}
