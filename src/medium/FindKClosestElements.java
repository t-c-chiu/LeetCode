package medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	
	public static void main(String[] args) {
		List<Integer> res = findClosestElements(new int[]{1, 3}, 1, 2);
		System.out.println(res);
	}
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		int i = find(arr, x);
		int left = i - 1;
		int right = i + 1;
		while (right - left - 1 < k) {
			if (left < 0) {
				right++;
				continue;
			}
			if (right == arr.length) {
				left--;
				continue;
			}
			
			if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
				left--;
			} else {
				right++;
			}
		}
		
		for (int j = left + 1; j < right; j++) {
			res.add(arr[j]);
		}
		return res;
	}
	
	private static int find(int[] arr, int x) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] < x) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		if (hi < 0) {
			return 0;
		} else if (lo > arr.length - 1) {
			return arr.length - 1;
		} else {
			return Math.abs(arr[hi] - x) <= Math.abs(arr[lo] - x) ? hi : lo;
		}
	}
}
