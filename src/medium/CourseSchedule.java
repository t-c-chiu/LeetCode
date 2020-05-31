package medium;

import java.util.*;

public class CourseSchedule {
	
	public static void main(String[] args) {
		CourseSchedule test = new CourseSchedule();
		System.out.println(test.canFinish(4, new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}}));
//		System.out.println(test.canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < prerequisites.length; i++)
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		
		int[] visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (hasCycle(graph, visited, i))
				return false;
		}
		return true;
	}
	
	private boolean hasCycle(List<Integer>[] graph, int[] visited, int course) {
		if (visited[course] == 1)
			return true;
		if (visited[course] == 2)
			return false;
		visited[course] = 1;
		
		for (int i = 0; i < graph[course].size(); i++) {
			if (hasCycle(graph, visited, graph[course].get(i)))
				return true;
		}
		visited[course] = 2;
		return false;
	}

//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		int[] inDegree = new int[numCourses];
//		for (int[] prerequisite : prerequisites)
//			inDegree[prerequisite[0]]++;
//
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 0; i < inDegree.length; i++) {
//			if (inDegree[i] == 0)
//				queue.offer(i);
//		}
//
//		while (!queue.isEmpty()) {
//			Integer course = queue.poll();
//			for (int[] prerequisite : prerequisites) {
//				if (prerequisite[1] == course && --inDegree[prerequisite[0]] == 0)
//					queue.offer(prerequisite[0]);
//			}
//		}
//
//		for (int i : inDegree) {
//			if (i != 0)
//				return false;
//		}
//		return true;
//	}
}
