package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
	
	public static void main(String[] args) {
		int res = mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}});
		System.out.println(res);
	}
	
	public static int mostBooked(int n, int[][] meetings) {
		Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
		boolean[] used = new boolean[n];
		int[] count = new int[n];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		for (int[] meeting : meetings) {
			int start = meeting[0], end = meeting[1], duration = end - start;
			while (!pq.isEmpty() && pq.peek()[0] <= start) {
				int[] poll = pq.poll();
				used[poll[1]] = false;
			}
			if (pq.size() == n) {
				int[] poll = pq.poll();
				count[poll[1]]++;
				poll[0] += duration;
				pq.offer(poll);
			} else {
				for (int i = 0; i < n; i++) {
					if (!used[i]) {
						used[i] = true;
						count[i]++;
						pq.offer(new int[]{end, i});
						break;
					}
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (count[i] > count[res]) {
				res = i;
			}
		}
		return res;
	}
}
