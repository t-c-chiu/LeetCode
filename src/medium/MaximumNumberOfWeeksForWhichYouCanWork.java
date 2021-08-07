package medium;

public class MaximumNumberOfWeeksForWhichYouCanWork {
	
	public static void main(String[] args) {
		long res = numberOfWeeks(new int[]{5, 7, 5, 7, 9, 7});
		System.out.println(res);
	}
	
	public static long numberOfWeeks(int[] milestones) {
		long sum = 0;
		int max = 0;
		for (int milestone : milestones) {
			sum += milestone;
			max = Math.max(max, milestone);
		}
		long rest = sum - max;
		return max <= rest ? sum : rest * 2 + 1;
	}
}
