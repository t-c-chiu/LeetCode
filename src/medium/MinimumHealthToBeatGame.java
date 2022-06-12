package medium;

public class MinimumHealthToBeatGame {
	
	public static void main(String[] args) {
		long res = minimumHealth(new int[]{2, 5, 3, 4}, 7);
		System.out.println(res);
	}
	
	public static long minimumHealth(int[] damage, int armor) {
		long sum = 0;
		int max = 0;
		for (int i : damage) {
			sum += i;
			max = Math.max(max, i);
		}
		return sum - Math.min(max, armor) + 1;
	}
}
