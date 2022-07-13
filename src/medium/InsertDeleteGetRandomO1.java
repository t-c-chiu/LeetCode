package medium;

import java.util.*;

public class InsertDeleteGetRandomO1 {
	
	public static void main(String[] args) {
		RandomizedSet test = new RandomizedSet();
		System.out.println(test.insert(1));
		System.out.println(test.remove(2));
		System.out.println(test.insert(2));
		System.out.println(test.getRandom());
		System.out.println(test.remove(1));
		System.out.println(test.insert(2));
		System.out.println(test.getRandom());
	}
	
	static class RandomizedSet {
		
		List<Integer> list;
		Map<Integer, Integer> map;
		
		public RandomizedSet() {
			list = new ArrayList<>();
			map = new HashMap<>();
		}
		
		public boolean insert(int val) {
			if (!map.containsKey(val)) {
				map.put(val, list.size());
				list.add(val);
				return true;
			}
			return false;
		}
		
		public boolean remove(int val) {
			if (map.containsKey(val)) {
				Integer pos = map.get(val);
				int lastIdx = list.size() - 1;
				int lastElement = list.get(lastIdx);
				if (pos < lastIdx) {
					list.set(pos, lastElement);
					map.put(lastElement, pos);
				}
				list.remove(lastIdx);
				map.remove(val);
				return true;
			}
			return false;
		}
		
		public int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
	}
}
