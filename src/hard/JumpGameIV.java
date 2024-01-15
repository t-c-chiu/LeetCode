package hard;

import java.util.*;

public class JumpGameIV {
	
	public static void main(String[] args) {
		int res = minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
		System.out.println(res);
	}
	
	public static int minJumps(int[] arr) {
		int n = arr.length;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(arr[i], new ArrayList<>());
			map.get(arr[i]).add(i);
		}
		boolean[] seen = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		int res = 0;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				Integer pos = queue.poll();
				if (pos == n - 1) {
					return res;
				}
				seen[pos] = true;
				int val = arr[pos];
				for (Integer next : map.get(val)) {
					if (seen[next]) {
						continue;
					}
					queue.offer(next);
				}
				map.get(val).clear();
				if (pos > 0 && !seen[pos - 1]) {
					queue.offer(pos - 1);
				}
				if (pos < n - 1 && !seen[pos + 1]) {
					queue.offer(pos + 1);
				}
			}
			res++;
		}
		return res;
	}
}
