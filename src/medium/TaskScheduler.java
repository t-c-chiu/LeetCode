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
	
	// n = 3, partCount = 2, emptySlot = 2, availableTasks = 4, idles = 0
	// A B C _ A B C _ A B C
	// A B C D E A B C D E A B C
	//
	// n = 5, partCount = 2, emptySlot = 6, availableTasks = 4, idles = 2
	// A B C _ _ _ A B C _ _ _ A B C
	// A B C D E _ A B C D E _ A B C
	public static int leastInterval(char[] tasks, int n) {
		int res = 0;
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
		while (!pq.isEmpty()) {
			int k = n + 1;
			List<Integer> nextTasks = new ArrayList<>();
			while (k > 0 && !pq.isEmpty()) {
				int remain = pq.poll();
				if (remain > 1) {
					nextTasks.add(remain - 1);
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
