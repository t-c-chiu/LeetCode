package medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	
	public static void main(String[] args) {
		List<Integer> res = findClosestElements(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, 4);
		System.out.println(res);
	}
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		int lo = 0, hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
				hi--;
			} else {
				lo++;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = lo; i <= hi; i++) {
			res.add(arr[i]);
		}
		return res;
	}
	/**
	 * ---x--arr[mid]---arr[mid+k]---
	 * ---arr[mid]--x---arr[mid+k]---
	 * ---arr[mid]---x--arr[mid+k]---
	 * ---arr[mid]---arr[mid+k]--x---
	 */
//	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
//		int lo = 0, hi = arr.length - k;
//		while (lo < hi) {
//			int mid = (lo + hi) / 2;
//			if (x <= arr[mid]) {
//				hi = mid;
//			} else if (x >= arr[mid + k]) {
//				lo = mid + 1;
//			} else {
//				if (x - arr[mid] <= arr[mid + k] - x) {
//					hi = mid;
//				} else {
//					lo = mid + 1;
//				}
//			}
//		}
//		List<Integer> res = new ArrayList<>();
//		for (int i = lo; i < lo + k; i++) {
//			res.add(arr[i]);
//		}
//		return res;
//	}
}
