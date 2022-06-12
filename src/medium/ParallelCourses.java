package medium;

import java.util.*;

public class ParallelCourses {
	
	public static void main(String[] args) {
		int res = minimumSemesters(3, new int[][]{{1, 3}, {2, 3}});
		System.out.println(res);
	}
	
	public static int minimumSemesters(int n, int[][] relations) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}
		for (int[] relation : relations) {
			map.get(relation[0]).add(relation[1]);
			inDegree.put(relation[1], inDegree.get(relation[1]) + 1);
		}
		Queue<Integer> queue = new LinkedList<>();
		for (Integer course : inDegree.keySet()) {
			if (inDegree.get(course) == 0) {
				queue.offer(course);
			}
		}
		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			n -= size;
			res++;
			for (int i = 0; i < size; i++) {
				Integer course = queue.poll();
				for (Integer nextCourse : map.get(course)) {
					inDegree.put(nextCourse, inDegree.get(nextCourse) - 1);
					if (inDegree.get(nextCourse) == 0) {
						queue.offer(nextCourse);
					}
				}
			}
		}
		return n == 0 ? res : -1;
	}
}
