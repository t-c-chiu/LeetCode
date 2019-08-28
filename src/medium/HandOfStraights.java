package medium;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HandOfStraights {
	
	public static void main(String[] args) {
		HandOfStraights test = new HandOfStraights();
		final boolean ans = test.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);
		System.out.println(ans);
	}
	
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand.length == 0 || hand.length % W != 0)
			return false;
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : hand)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		while (!map.isEmpty()) {
			Integer key = map.firstKey();
			decreaseKey(map, key);
			for (int i = 1; i < W; i++) {
				if (!map.containsKey(++key))
					return false;
				decreaseKey(map, key);
			}
		}
		return true;
	}
	
	private void decreaseKey(TreeMap<Integer, Integer> map, Integer key) {
		Integer value = map.get(key);
		if (value == 1)
			map.remove(key);
		else
			map.put(key, value - 1);
	}
}
