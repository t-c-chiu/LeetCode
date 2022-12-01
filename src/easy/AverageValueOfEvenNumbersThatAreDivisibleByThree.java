package easy;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
	
	public static void main(String[] args) {
		int res = averageValue(new int[]{1, 3, 6, 10, 12, 15});
		System.out.println(res);
	}
	
	public static int averageValue(int[] nums) {
		int sum = 0, count = 0;
		for (int num : nums) {
			if (num % 2 == 0 && num % 3 == 0) {
				sum += num;
				count++;
			}
		}
		return count == 0 ? 0 : sum / count;
	}
}
