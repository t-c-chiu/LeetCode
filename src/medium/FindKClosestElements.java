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
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = lo; i <= hi; i++) {
			res.add(arr[i]);
		}
		return res;
	}
}
