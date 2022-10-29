package medium;

import java.util.Arrays;

public class BrightestPositionOnStreet {
	
	public static void main(String[] args) {
		int res = brightestPosition(new int[][]{{1, 0}, {0, 1}});
		System.out.println(res);
	}
	
	public static int brightestPosition(int[][] lights) {
		int n = lights.length, max = 0, brightness = 0, res = 0;
		int[] start = new int[n], end = new int[n];
		for (int i = 0; i < n; i++) {
			int position = lights[i][0], range = lights[i][1];
			start[i] = position - range;
			end[i] = position + range;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int startIdx = 0, endIdx = 0;
		while (startIdx < n) {
			int startPos = start[startIdx], endPos = end[endIdx];
			if (startPos <= endPos) {
				brightness++;
				startIdx++;
			} else {
				brightness--;
				endIdx++;
			}
			if (brightness > max) {
				max = brightness;
				res = startPos;
			}
		}
		return res;
	}
//	public static int brightestPosition(int[][] lights) {
//		int max = 0, brightness = 0, res = Integer.MIN_VALUE;
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for (int[] light : lights) {
//			int position = light[0], range = light[1], from = position - range, to = position + range + 1;
//			map.put(from, map.getOrDefault(from, 0) + 1);
//			map.put(to, map.getOrDefault(to, 0) - 1);
//		}
//		for (Integer position : map.keySet()) {
//			brightness += map.get(position);
//			if (brightness > max) {
//				max = brightness;
//				res = position;
//			}
//		}
//		return res;
//	}
}
