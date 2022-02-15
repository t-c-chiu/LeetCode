package medium;

import java.util.*;

public class CourseScheduleII {
	
	public static void main(String[] args) {
		int[] res = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		int[] indegree = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] prerequisite : prerequisites) {
			int pre = prerequisite[1];
			int post = prerequisite[0];
			graph[pre].add(post);
			indegree[post]++;
		}
		int[] res = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			res[count++] = course;
			List<Integer> posts = graph[course];
			for (int post : posts) {
				if (--indegree[post] == 0) {
					queue.offer(post);
				}
			}
		}
		return count == numCourses ? res : new int[]{};
	}
}
