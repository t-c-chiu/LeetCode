package hard;

import java.util.*;

public class Insert_Delete_GetRandom_O1_Duplicates_allowed {
	
	public static void main(String[] args) {
		RandomizedCollection test = new Insert_Delete_GetRandom_O1_Duplicates_allowed().new RandomizedCollection();
		test.insert(1);
		test.remove(1);
		test.insert(1);
	}
	
	class RandomizedCollection {
		
		List<Integer> nums;
		Map<Integer, Set<Integer>> locs;
		
		public RandomizedCollection() {
			nums = new ArrayList<>();
			locs = new HashMap<>();
		}
		
		public boolean insert(int val) {
			boolean containsVal = locs.containsKey(val);
			if (!containsVal) {
				locs.put(val, new HashSet<>());
			}
			locs.get(val).add(nums.size());
			nums.add(val);
			return !containsVal;
		}
		
		public boolean remove(int val) {
			if (!locs.containsKey(val)) {
				return false;
			}
			int loc = locs.get(val).iterator().next();
			locs.get(val).remove(loc);
			int lastIndex = nums.size() - 1;
			if (loc < lastIndex) {
				int last = nums.get(lastIndex);
				nums.set(loc, last);
				Set<Integer> lastLocs = locs.get(last);
				lastLocs.remove(lastIndex);
				lastLocs.add(loc);
			}
			nums.remove(lastIndex);
			if (locs.get(val).isEmpty()) {
				locs.remove(val);
			}
			return true;
		}
		
		public int getRandom() {
			return nums.get(new Random().nextInt(nums.size()));
		}
	}
}
