package hard;

import java.util.*;

public class FrogJump {
	
	public static void main(String[] args) {
		boolean res = canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
		System.out.println(res);
	}
	
	public static boolean canCross(int[] stones) {
		int n = stones.length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(stones[i], new HashSet<>());
		}
		map.get(0).add(1);
		for (int i = 0; i < n - 1; i++) {
			int stone = stones[i];
			for (Integer step : map.get(stone)) {
				int next = stone + step;
				if (next == stones[n - 1]) {
					return true;
				}
				Set<Integer> set = map.get(next);
				if (set != null) {
					set.add(step);
					if (step > 1) {
						set.add(step - 1);
					}
					set.add(step + 1);
				}
			}
		}
		return false;
	}
	
}
