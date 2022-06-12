package medium;

import java.util.*;

public class FindingTheUsersActiveMinutes {
	
	public static void main(String[] args) {
		int[] res = findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5);
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
		int[] res = new int[k];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] log : logs) {
			map.putIfAbsent(log[0], new HashSet<>());
			map.get(log[0]).add(log[1]);
		}
		for (Set<Integer> set : map.values()) {
			res[set.size() - 1]++;
		}
		return res;
	}
}
