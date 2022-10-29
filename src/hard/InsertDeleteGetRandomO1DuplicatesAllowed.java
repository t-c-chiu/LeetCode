package hard;

import java.util.*;

public class InsertDeleteGetRandomO1DuplicatesAllowed {
	
	public static void main(String[] args) {
		RandomizedCollection randomizedCollection = new RandomizedCollection();
		randomizedCollection.insert(1);   // return true since the collection does not contain 1.
		// Inserts 1 into the collection.
		randomizedCollection.insert(1);   // return false since the collection contains 1.
		// Inserts another 1 into the collection. Collection now contains [1,1].
		randomizedCollection.insert(2);   // return true since the collection does not contain 2.
		// Inserts 2 into the collection. Collection now contains [1,1,2].
		randomizedCollection.getRandom(); // getRandom should:
		// - return 1 with probability 2/3, or
		// - return 2 with probability 1/3.
		randomizedCollection.remove(1);   // return true since the collection contains 1.
		// Removes 1 from the collection. Collection now contains [1,2].
		randomizedCollection.getRandom(); // getRandom should return 1 or 2, both equally likely.
	}
	
	static class RandomizedCollection {
		
		List<Integer> list = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();
		
		public RandomizedCollection() {
		
		}
		
		public boolean insert(int val) {
			boolean isContain = map.containsKey(val);
			if (!isContain) {
				map.put(val, new LinkedHashSet<>());
			}
			map.get(val).add(list.size());
			list.add(val);
			return !isContain;
		}
		
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			int index = map.get(val).iterator().next();
			map.get(val).remove(index);
			int lastIndex = list.size() - 1;
			if (index < lastIndex) {
				int lastElement = list.get(lastIndex);
				list.set(index, lastElement);
				map.get(lastElement).remove(lastIndex);
				map.get(lastElement).add(index);
			}
			list.remove(lastIndex);
			if (map.get(val).isEmpty()) {
				map.remove(val);
			}
			return true;
		}
		
		public int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
	}
}
