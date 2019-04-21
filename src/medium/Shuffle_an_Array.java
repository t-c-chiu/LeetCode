package medium;

import java.util.Random;

public class Shuffle_an_Array {
	
	public static void main(String[] args) {
		Shuffle_an_Array saa = new Shuffle_an_Array(new int[]{1, 2, 3});
		for (int i : saa.shuffle()) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : saa.reset()) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : saa.shuffle()) {
			System.out.print(i);
		}
	}
	
	private int[] origin;
	private Random random;
	
	public Shuffle_an_Array(int[] nums) {
		origin = nums;
		random = new Random();
	}
	
	/**
	 * Resets the array to its original configuration and return it.
	 */
	public int[] reset() {
		return origin;
	}
	
	/**
	 * Returns a random shuffling of the array.
	 */
	public int[] shuffle() {
		int[] shuffled = origin.clone();
		int length = shuffled.length;
		for (int i = 0; i < length; i++) {
			swap(shuffled, i, random.nextInt(i + 1));
		}
		return shuffled;
	}
	
	private void swap(int[] shuffled, int i, int j) {
		int temp = shuffled[i];
		shuffled[i] = shuffled[j];
		shuffled[j] = temp;
	}
}
