package medium;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithACertainSum {
	
	public static void main(String[] args) {
		FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
		int res = findSumPairs.count(7);// return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
		System.out.println(res);
		findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
		res = findSumPairs.count(8);  // return 2; pairs (5,2), (5,4) make 3 + 5
		System.out.println(res);
		res = findSumPairs.count(4);  // return 1; pair (5,0) makes 3 + 1
		System.out.println(res);
		findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
		findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
		res = findSumPairs.count(7);  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
		System.out.println(res);
	}
	
	static class FindSumPairs {
		int[] nums1;
		int[] nums2;
		Map<Integer, Integer> map;
		
		public FindSumPairs(int[] nums1, int[] nums2) {
			this.nums1 = nums1;
			this.nums2 = nums2;
			map = new HashMap<>();
			for (int i : nums2) {
				updateMap(i, 1);
			}
		}
		
		private void updateMap(int i, int v) {
			map.put(i, map.getOrDefault(i, 0) + v);
		}
		
		public void add(int index, int val) {
			updateMap(nums2[index], -1);
			nums2[index] += val;
			updateMap(nums2[index], 1);
		}
		
		public int count(int tot) {
			int count = 0;
			for (int i : nums1) {
				int target = tot - i;
				count += map.getOrDefault(target, 0);
			}
			return count;
		}
	}
}
