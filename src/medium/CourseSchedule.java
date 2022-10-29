package medium;

import java.util.*;

public class CourseSchedule {
	
	public static void main(String[] args) {
		boolean res = canFinish(2, new int[][]{{1, 0}, {0, 1}});
		System.out.println(res);
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}
		for (int[] prerequisite : prerequisites) {
			int pre = prerequisite[0], post = prerequisite[1];
			map.get(pre).add(post);
			inDegree.put(post, inDegree.get(post) + 1);
		}
		Queue<Integer> queue = new LinkedList<>();
		for (Integer course : inDegree.keySet()) {
			if (inDegree.get(course) == 0) {
				queue.offer(course);
			}
		}
		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			numCourses--;
			for (Integer next : map.get(cur)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					queue.offer(next);
				}
			}
		}
		return numCourses == 0;
	}
	
}
