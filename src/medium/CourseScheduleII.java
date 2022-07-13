package medium;

import java.util.*;

public class CourseScheduleII {
	
	public static void main(String[] args) {
		int[] res = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}
		for (int[] pre : prerequisites) {
			graph.get(pre[1]).add(pre[0]);
			inDegree.put(pre[0], inDegree.get(pre[0]) + 1);
		}
		Queue<Integer> q = new LinkedList<>();
		for (Integer course : inDegree.keySet()) {
			if (inDegree.get(course) == 0) {
				q.offer(course);
			}
		}
		int i = 0;
		int[] res = new int[numCourses];
		while (!q.isEmpty()) {
			Integer course = q.poll();
			res[i++] = course;
			for (Integer next : graph.get(course)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					q.offer(next);
				}
			}
		}
		return i == numCourses ? res : new int[0];
	}
}
