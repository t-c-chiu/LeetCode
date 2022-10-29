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
		
		Map<Integer, Integer> map;
		List<Integer> list;
		
		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}
		
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}
			map.put(val, list.size());
			list.add(val);
			return true;
		}
		
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			int index = map.get(val);
			int lastEle = list.get(list.size() - 1);
			if (val != lastEle) {
				list.set(index, lastEle);
				map.put(lastEle, index);
			}
			map.remove(val);
			list.remove(list.size() - 1);
			return true;
		}
		
		public int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
	}
}
