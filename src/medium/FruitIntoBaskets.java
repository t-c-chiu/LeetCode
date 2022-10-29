package medium;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
	
	public static void main(String[] args) {
		int res = totalFruit(new int[]{1, 2, 3, 2, 2});
		System.out.println(res);
	}
	
	public static int totalFruit(int[] fruits) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int r = 0, l = 0; r < fruits.length; r++) {
			map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
			while (map.size() > 2) {
				map.put(fruits[l], map.get(fruits[l]) - 1);
				map.remove(fruits[l], 0);
				l++;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
