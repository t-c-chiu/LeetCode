package easy;

public class MajorityElement {
	
	public static void main(String[] args) {
		int res = majorityElement(new int[]{2, 2, 2, 1, 1, 1, 2});
		System.out.println(res);
	}
	
	public static int majorityElement(int[] nums) {
		int res = 0, count = 0;
		for (int num : nums) {
			if (num == res) {
				count++;
			} else {
				if (count == 0) {
					res = num;
					count = 1;
				} else {
					count--;
				}
			}
		}
		return res;
	}
}
