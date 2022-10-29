package medium;

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		int res = findKthLargest(new int[]{3, 2, 2, 2, 1, 4}, 3);
		System.out.println(res);
	}
	
	public static int findKthLargest(int[] nums, int k) {
		int n = nums.length, lo = 0, hi = n - 1;
		k = n - k;
		while (lo <= hi) {
			int partition = partition(nums, lo, hi);
			if (partition == k) {
				return nums[k];
			} else if (partition < k) {
				lo = partition + 1;
			} else {
				hi = partition - 1;
			}
		}
		return nums[lo];
	}
	
	private static int partition(int[] nums, int lo, int hi) {
		int pivot = nums[lo], start = lo;
		while (lo <= hi) {
			while (lo <= hi && nums[lo] <= pivot) {
				lo++;
			}
			while (lo <= hi && nums[hi] > pivot) {
				hi--;
			}
			if (lo >= hi) {
				break;
			}
			swap(nums, lo, hi);
		}
		swap(nums, start, hi);
		return hi;
	}
	
	
	private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
	
	
}
