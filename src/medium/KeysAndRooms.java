package medium;

import java.util.*;

public class KeysAndRooms {
	
	public static void main(String[] args) {
		boolean res = canVisitAllRooms(Arrays.asList(
				Arrays.asList(1, 3),
				Arrays.asList(3, 0, 1),
				Arrays.asList(2),
				Arrays.asList(0)
		));
		System.out.println(res);
	}
	
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean[] visited = new boolean[n];
		Queue<Integer> keys = new LinkedList<>();
		keys.offer(0);
		while (!keys.isEmpty()) {
			Integer key = keys.poll();
			if (visited[key]) {
				continue;
			}
			visited[key] = true;
			for (Integer nextKey : rooms.get(key)) {
				keys.offer(nextKey);
			}
		}
		for (boolean b : visited) {
			if (!b) {
				return false;
			}
		}
		return true;
	}
}
