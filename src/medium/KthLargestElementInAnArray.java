package medium;

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		int res = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
		System.out.println(res);
	}
	
	public static int findKthLargest(int[] nums, int k) {
		int n = nums.length, lo = 0, hi = n - 1;
		k = n - k;
		while (lo <= hi) {
			int pivot = partition(nums, lo, hi);
			if (pivot < k) {
				lo = pivot + 1;
			} else if (pivot > k) {
				hi = pivot - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}
	
	private static int partition(int[] nums, int lo, int hi) {
		int pivot = lo;
		while (lo <= hi) {
			while (lo <= hi && nums[lo] <= nums[pivot]) {
				lo++;
			}
			while (lo <= hi && nums[pivot] < nums[hi]) {
				hi--;
			}
			if (lo > hi) {
				break;
			}
			swap(nums, lo, hi);
		}
		swap(nums, pivot, hi);
		return hi;
	}
	
	private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

//	public static int findKthLargest(int[] nums, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		for (int num : nums) {
//			if (pq.size() < k) {
//				pq.offer(num);
//			} else if (pq.peek() < num) {
//				pq.poll();
//				pq.offer(num);
//			}
//		}
//		return pq.poll();
//	}
	
}
