package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	
	public static void main(String[] args) {
		boolean res = canFinish(2, new int[][]{{1, 0}, {0, 1}});
		System.out.println(res);
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		int[] indegree = new int[numCourses];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] prerequisite : prerequisites) {
			int pre = prerequisite[1];
			int post = prerequisite[0];
			graph[pre].add(post);
			indegree[post]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			List<Integer> posts = graph[course];
			for (Integer post : posts) {
				if (--indegree[post] == 0) {
					queue.offer(post);
				}
			}
		}
		return count == numCourses;
	}
	
	
}
