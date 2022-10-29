package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	
	public static void main(String[] args) {
		List<Integer> res = countSmaller(new int[]{5, 2, 6, 1});
		System.out.println(res);
	}
	
	public static List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		List<Info> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Info(nums[i], i));
		}
		mergeAndCount(list, 0, n - 1, count);
		List<Integer> res = new ArrayList<>();
		for (int i : count) {
			res.add(i);
		}
		return res;
	}
	
	private static List<Info> mergeAndCount(List<Info> list, int start, int end, int[] count) {
		if (start == end) {
			return Arrays.asList(list.get(start));
		}
		int mid = (start + end) / 2;
		List<Info> left = mergeAndCount(list, start, mid, count);
		List<Info> right = mergeAndCount(list, mid + 1, end, count);
		List<Info> merged = new ArrayList<>();
		int leftIdx = 0;
		int rightIdx = 0;
		int smallerCount = 0;
		while (leftIdx < left.size() && rightIdx < right.size()) {
			Info leftInfo = left.get(leftIdx);
			Info rightInfo = right.get(rightIdx);
			if (leftInfo.val > rightInfo.val) {
				smallerCount++;
				merged.add(rightInfo);
				rightIdx++;
			} else {
				count[leftInfo.index] += smallerCount;
				merged.add(leftInfo);
				leftIdx++;
			}
		}
		while (leftIdx < left.size()) {
			Info leftInfo = left.get(leftIdx);
			count[leftInfo.index] += smallerCount;
			merged.add(leftInfo);
			leftIdx++;
		}
		while (rightIdx < right.size()) {
			merged.add(right.get(rightIdx));
			rightIdx++;
		}
		return merged;
	}
	
	static class Info {
		int val;
		int index;
		
		public Info(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
}
