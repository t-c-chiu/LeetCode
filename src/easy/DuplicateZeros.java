package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {
	
	public static void main(String[] args) {
		DuplicateZeros test = new DuplicateZeros();
		
		int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
		test.duplicateZeros(arr);
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		
		arr = new int[]{1, 2, 3};
		test.duplicateZeros(arr);
		Arrays.stream(arr).forEach(System.out::print);
	}
	
	public void duplicateZeros(int[] arr) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
			if (arr[i] == 0)
				queue.add(0);
			arr[i] = queue.poll();
		}
	}
}
