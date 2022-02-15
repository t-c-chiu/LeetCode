package medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		int res = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
		System.out.println(res);
	}
	
	public static int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		k = nums.length - k;
		while (start < end) {
			int pivot = partition(nums, start, end);
			if (pivot < k) {
				start = pivot + 1;
			} else if (pivot > k) {
				end = pivot - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}
	
	private static int partition(int[] nums, int start, int end) {
		int pivot = start;
		while (start <= end) {
			while (start <= end && nums[start] <= nums[pivot]) {
				start++;
			}
			while (start <= end && nums[end] > nums[pivot]) {
				end--;
			}
			if (start > end) {
				break;
			}
			swap(nums, start, end);
		}
		swap(nums, pivot, end);
		return end;
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
