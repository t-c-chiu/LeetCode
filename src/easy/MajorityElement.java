package easy;

public class MajorityElement {
	
	public static void main(String[] args) {
		int res = majorityElement(new int[]{2, 2, 2, 1, 1, 1, 2});
		System.out.println(res);
	}
	
	public static int majorityElement(int[] nums) {
		int candidate = 0;
		int count = 0;
		for (int num : nums) {
			if (num == candidate) {
				count++;
			} else if (count == 0) {
				candidate = num;
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}
