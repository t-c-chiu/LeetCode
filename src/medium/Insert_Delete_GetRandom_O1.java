package medium;

import java.util.*;

public class Insert_Delete_GetRandom_O1 {
	
	public static void main(String[] args) {
		RandomizedSet test = new Insert_Delete_GetRandom_O1().new RandomizedSet();
		System.out.println(test.insert(1));
		System.out.println(test.remove(2));
		System.out.println(test.insert(2));
		System.out.println(test.getRandom());
		System.out.println(test.remove(1));
		System.out.println(test.insert(2));
		System.out.println(test.getRandom());
	}
	
	class RandomizedSet {
		
		private List<Integer> nums;
		private Map<Integer, Integer> locs;
		
		public RandomizedSet() {
			nums = new ArrayList<>();
			locs = new HashMap<>();
		}
		
		public boolean insert(int val) {
			if (!locs.containsKey(val)) {
				locs.put(val, nums.size());
				nums.add(val);
				return true;
			}
			return false;
		}
		
		public boolean remove(int val) {
			if (locs.containsKey(val)) {
				Integer index = locs.get(val);
				int lastIndex = nums.size() - 1;
				if (index < lastIndex) {
					int last = nums.get(lastIndex);
					nums.set(index, last);
					locs.put(last, index);
				}
				locs.remove(val);
				nums.remove(lastIndex);
				return true;
			}
			return false;
		}
		
		public int getRandom() {
			return nums.get(new Random().nextInt(nums.size()));
		}
	}
}
