package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
	
	public static void main(String[] args) {
		int[] res = findOrder(2, new int[][]{
				{1, 0}
		});
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i] + " ");
		}
	}
	
	/**
	 * 0 ->
	 * 1 -> 0
	 * 2 -> 0
	 * 3 -> 1 2
	 */
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int id = prerequisites[i][0];
			int preId = prerequisites[i][1];
			List<Integer> pres = map.getOrDefault(id, new ArrayList<>());
			pres.add(preId);
			map.putIfAbsent(id, pres);
		}
		
		List<Integer> res = new ArrayList<>();
		boolean[] visiting = new boolean[numCourses];
		boolean[] finished = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!finishCourse(i, visiting, finished, map, res)) {
				return new int[0];
			}
		}
		return res.stream().mapToInt(i -> i).toArray();
	}
	
	private static boolean finishCourse(int id, boolean[] visiting, boolean[] finished, Map<Integer, List<Integer>> map, List<Integer> res) {
		if (finished[id]) {
			return true;
		}
		
		List<Integer> pres = map.get(id);
		if (pres == null) {
			res.add(id);
			finished[id] = true;
			return true;
		}
		
		for (int j = 0; j < pres.size(); j++) {
			Integer preId = pres.get(j);
			if (!finished[preId]) {
				if (visiting[preId]) {
					return false;
				}
				visiting[preId] = true;
				if (!finishCourse(preId, visiting, finished, map, res)) {
					return false;
				}
				visiting[preId] = false;
			}
		}
		res.add(id);
		finished[id] = true;
		return true;
	}
}
