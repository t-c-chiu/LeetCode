package easy;

import java.util.*;

public class MinimumAbsoluteDifference {
	
	public static void main(String[] args) {
		MinimumAbsoluteDifference test = new MinimumAbsoluteDifference();
		System.out.println(test.minimumAbsDifference(new int[]{4, 2, 1, 3}));
		System.out.println(test.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
		System.out.println(test.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
	}
	
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 1, min = Integer.MAX_VALUE; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if (diff < min) {
				res = new ArrayList<>();
				res.add(Arrays.asList(arr[i - 1], arr[i]));
				min = diff;
			} else if (diff == min)
				res.add(Arrays.asList(arr[i - 1], arr[i]));
		}
		return res;
	}
}
