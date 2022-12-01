package hard;

import java.util.*;

public class FindServersThatHandledMostNumberOfRequests {
	
	public static void main(String[] args) {
		List<Integer> res = busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3});
		System.out.println(res);
	}
	
	public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		TreeSet<Integer> servers = new TreeSet<>();
		for (int i = 0; i < k; i++) {
			servers.add(i);
		}
		int[] count = new int[k];
		int n = arrival.length;
		for (int i = 0; i < n; i++) {
			int start = arrival[i];
			int end = start + load[i];
			while (!pq.isEmpty() && pq.peek()[1] <= start) {
				int[] poll = pq.poll();
				servers.add(poll[0]);
			}
			if (pq.size() == k) {
				continue;
			}
			int targetServer = i % k;
			int server = servers.ceiling(targetServer) != null ? servers.ceiling(targetServer) : servers.first();
			servers.remove(server);
			count[server]++;
			pq.offer(new int[]{server, end});
		}
		List<Integer> res = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (count[i] > max) {
				max = count[i];
				res = new ArrayList<>();
				res.add(i);
			} else if (count[i] == max) {
				res.add(i);
			}
		}
		return res;
	}
}
