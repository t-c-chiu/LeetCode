package medium;

import java.util.*;

public class CourseScheduleII {
	
	public static void main(String[] args) {
		int[] res = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> preCount = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<>());
			preCount.put(i, 0);
		}
		for (int[] prerequisite : prerequisites) {
			int pre = prerequisite[1], post = prerequisite[0];
			map.get(pre).add(post);
			preCount.put(post, preCount.get(post) + 1);
		}
		Queue<Integer> queue = new LinkedList<>();
		for (Integer course : preCount.keySet()) {
			if (preCount.get(course) == 0) {
				queue.offer(course);
			}
		}
		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer course = queue.poll();
			res.add(course);
			numCourses--;
			for (Integer next : map.get(course)) {
				preCount.put(next, preCount.get(next) - 1);
				if (preCount.get(next) == 0) {
					queue.offer(next);
				}
			}
		}
		if (numCourses != 0) {
			return new int[]{};
		}
		int[] resArr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			resArr[i] = res.get(i);
		}
		return resArr;
	}
}
