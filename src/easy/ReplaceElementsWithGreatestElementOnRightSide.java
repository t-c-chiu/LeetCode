package easy;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
	
	public static void main(String[] args) {
		int[] res = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] replaceElements(int[] arr) {
		int n = arr.length;
		int greatest = arr[n - 1];
		arr[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = greatest;
			greatest = Math.max(greatest, temp);
		}
		return arr;
	}
}
