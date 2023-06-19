package medium;

import java.util.*;

public class CourseSchedule {
	
	public static void main(String[] args) {
		boolean res = canFinish(2, new int[][]{{1, 0}, {0, 1}});
		System.out.println(res);
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> inDegree = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			int post = prerequisite[0], pre = prerequisite[1];
			inDegree.put(post, inDegree.get(post) + 1);
			graph.get(pre).add(post);
		}
		Queue<Integer> queue = new LinkedList<>();
		for (Integer i : inDegree.keySet()) {
			if (inDegree.get(i) == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			numCourses--;
			Integer i = queue.poll();
			for (Integer next : graph.get(i)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					queue.offer(next);
				}
			}
		}
		return numCourses == 0;
	}
	
}
