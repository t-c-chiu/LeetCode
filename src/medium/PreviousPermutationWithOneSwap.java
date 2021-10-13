package medium;

import java.util.Arrays;

public class PreviousPermutationWithOneSwap {
	
	public static void main(String[] args) {
		int[] res = prevPermOpt1(new int[]{5, 1, 6, 8, 4});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] prevPermOpt1(int[] arr) {
		int i = -1;
		for (int j = arr.length - 2; j >= 0; j--) {
			if (arr[j] > arr[j + 1]) {
				i = j;
				break;
			}
		}
		if (i == -1) {
			return arr;
		}
		
		for (int j = arr.length - 1; j > i; j--) {
			if (arr[j] < arr[i] && arr[j] != arr[j - 1]) {
				swap(arr, i, j);
				break;
			}
		}
		return arr;
	}

//	public static int[] prevPermOpt1(int[] arr) {
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for (int i = arr.length - 1; i >= 0; i--) {
//			Map.Entry<Integer, Integer> entry = map.lowerEntry(arr[i]);
//			if (entry != null) {
//				swap(arr, i, entry.getValue());
//				break;
//			}
//			map.put(arr[i], i);
//		}
//		return arr;
//	}
	
	private static void swap(int[] arr, int i, Integer j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
