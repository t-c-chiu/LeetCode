package medium;

import java.util.*;

public class MostProfitAssigningWork {
	
	public static void main(String[] args) {
		int res = maxProfitAssignment(
				new int[]{2, 4, 6, 8, 10},
				new int[]{10, 20, 30, 40, 50},
				new int[]{4, 5, 6, 7});
		System.out.println(res);
	}
	
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int n = difficulty.length;
		int[][] jobs = new int[n][2];
		for (int i = 0; i < n; i++) {
			jobs[i][0] = difficulty[i];
			jobs[i][1] = profit[i];
		}
		Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
		Arrays.sort(worker);
		int i = 0, best = 0, res = 0;
		for (int ability : worker) {
			while (i < n && jobs[i][0] <= ability) {
				best = Math.max(best, jobs[i][1]);
				i++;
			}
			res += best;
		}
		return res;
	}

//	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		map.put(0, 0);
//		for (int i = 0; i < difficulty.length; i++) {
//			map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
//		}
//		int best = 0;
//		for (Integer key : map.keySet()) {
//			best = Math.max(best, map.get(key));
//			map.put(key, best);
//		}
//		int res = 0;
//		for (int ability : worker) {
//			res += map.floorEntry(ability).getValue();
//		}
//		return res;
//	}

//	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		int n = difficulty.length;
//		int[][] jobs = new int[n][2];
//		for (int i = 0; i < n; i++) {
//			jobs[i][0] = difficulty[i];
//			jobs[i][1] = profit[i];
//		}
//		Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
//		int maxProfit = 0;
//		for (int i = 0; i < n; i++) {
//			int[] job = jobs[i];
//			if (job[1] > maxProfit) {
//				maxProfit = job[1];
//			}
//			map.put(job[0], maxProfit);
//		}
//		int res = 0;
//		for (int diff : worker) {
//			Integer floorKey = map.floorKey(diff);
//			if (floorKey == null) {
//				continue;
//			}
//			res += map.get(floorKey);
//		}
//		return res;
//	}
}
