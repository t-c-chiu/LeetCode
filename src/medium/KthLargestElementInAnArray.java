package medium;

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		KthLargestElementInAnArray test = new KthLargestElementInAnArray();
		int res = test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
		System.out.println(res);
	}
	
	public int findKthLargest(int[] nums, int k) {
		int left = 0, right = nums.length - 1;
		while (true) {
			int pos = partition(nums, left, right);
			if (pos + 1 == k)
				return nums[pos];
			else if (pos + 1 > k)
				right = pos - 1;
			else
				left = pos + 1;
		}
	}
	
	private int partition(int[] nums, int left, int right) {
		int pivot = left;
		while (left <= right) {
			while (left <= right && nums[left] >= nums[pivot])
				left++;
			while (left <= right && nums[right] < nums[pivot])
				right--;
			if (left > right)
				break;
			swap(nums, left, right);
		}
		swap(nums, pivot, right);
		return right;
	}
	
	private void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}

//	public int findKthLargest(int[] nums, int k) {
//		PriorityQueue<Integer> queue = new PriorityQueue<>();
//		for (int num : nums) {
//			queue.add(num);
//			if (queue.size() > k)
//				queue.poll();
//		}
//		return queue.poll();
//	}
}
