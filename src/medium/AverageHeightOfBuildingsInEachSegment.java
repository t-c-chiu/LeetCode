package medium;

import java.util.*;

public class AverageHeightOfBuildingsInEachSegment {
	
	public static void main(String[] args) {
		int[][] res = averageHeightOfBuildings(new int[][]{{1, 2, 1}, {5, 6, 1}});
		for (int[] arr : res) {
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}
	
	public static int[][] averageHeightOfBuildings(int[][] buildings) {
		Map<Integer, int[]> map = new TreeMap<>();
		for (int[] building : buildings) {
			int start = building[0], end = building[1], height = building[2];
			if (map.containsKey(start)) {
				map.get(start)[0] += height;
				map.get(start)[1]++;
			} else {
				map.put(start, new int[]{height, 1});
			}
			if (map.containsKey(end)) {
				map.get(end)[0] -= height;
				map.get(end)[1]--;
			} else {
				map.put(end, new int[]{-height, -1});
			}
		}
		
		List<int[]> list = new ArrayList<>();
		int prev = 0, height = 0, count = 0;
		for (Integer cur : map.keySet()) {
			if (height > 0) {
				int avg = height / count;
				if (!list.isEmpty() && prev == list.get(list.size() - 1)[1] && list.get(list.size() - 1)[2] == avg) {
					list.get(list.size() - 1)[1] = cur;
				} else {
					list.add(new int[]{prev, cur, avg});
				}
			}
			height += map.get(cur)[0];
			count += map.get(cur)[1];
			prev = cur;
		}
		int[][] res = new int[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
