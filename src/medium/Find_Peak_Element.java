package medium;

public class Find_Peak_Element {
	
	public static void main(String[] args) {
		Find_Peak_Element test = new Find_Peak_Element();
		int peakElement = test.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
		System.out.println(peakElement);
	}
	
	public int findPeakElement(int[] nums) {
		if (nums.length == 1 || nums[0] > nums[1]) {
			return 0;
		}
		int len = nums.length;
		if (nums[len - 1] > nums[len - 2]) {
			return len - 1;
		}
		for (int i = 1; i < len - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return -1;
	}
}
