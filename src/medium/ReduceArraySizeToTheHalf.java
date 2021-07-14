package medium;

import java.util.*;
import java.util.stream.Collectors;

public class ReduceArraySizeToTheHalf {
	
	public static void main(String[] args) {
		int res = minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
		System.out.println(res);
	}
	
	public static int minSetSize(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		int[] count = new int[n + 1];
		for (Integer occur : map.values()) {
			count[occur]++;
		}
		
		int res = 0;
		for (int i = n; i >= 0; i--) {
			if (count[i] == 0) {
				continue;
			}
			for (int j = 0; j < count[i]; j++) {
				n -= i;
				res++;
				if (n <= arr.length / 2) {
					return res;
				}
			}
		}
		return res;
	}

//	public static int minSetSize(int[] arr) {
//		int n = arr.length;
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//		}
//
//		int res = 0;
//		List<Integer> occurs = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		for (Integer occur : occurs) {
//			n -= occur;
//			res++;
//			if (n <= arr.length / 2) {
//				break;
//			}
//		}
//		return res;
//	}
}
