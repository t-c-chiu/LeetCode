package medium;

public class RangeSumQueryMutable {
	
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[]{1, 3, 5});
		System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
		numArray.update(1, 2);   // nums = [1, 2, 5]
		System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8
	}
	
	static class NumArray {
		
		class SegmentTreeNode {
			int start, end, sum;
			SegmentTreeNode left, right;
			
			SegmentTreeNode(int start, int end) {
				this.start = start;
				this.end = end;
			}
		}
		
		SegmentTreeNode root;
		
		public NumArray(int[] nums) {
			root = buildTree(nums, 0, nums.length - 1);
		}
		
		private SegmentTreeNode buildTree(int[] nums, int start, int end) {
			if (start > end) {
				return null;
			}
			SegmentTreeNode node = new SegmentTreeNode(start, end);
			if (start == end) {
				node.sum = nums[start];
				return node;
			}
			int mid = (start + end) / 2;
			node.left = buildTree(nums, start, mid);
			node.right = buildTree(nums, mid + 1, end);
			if (node.left != null) {
				node.sum += node.left.sum;
			}
			if (node.right != null) {
				node.sum += node.right.sum;
			}
			return node;
		}
		
		public void update(int index, int val) {
			update(index, val, root);
		}
		
		private void update(int index, int val, SegmentTreeNode node) {
			if (node.start == index && node.end == index) {
				node.sum = val;
				return;
			}
			int mid = (node.start + node.end) / 2;
			if (index <= mid) {
				update(index, val, node.left);
			} else {
				update(index, val, node.right);
			}
			node.sum = node.left.sum + node.right.sum;
		}
		
		public int sumRange(int left, int right) {
			return sumRange(left, right, root);
		}
		
		private int sumRange(int left, int right, SegmentTreeNode node) {
			if (node.start == left && node.end == right) {
				return node.sum;
			}
			int mid = (node.start + node.end) / 2;
			if (right <= mid) {
				return sumRange(left, right, node.left);
			} else if (left > mid) {
				return sumRange(left, right, node.right);
			}
			return sumRange(left, mid, node.left) + sumRange(mid + 1, right, node.right);
		}
	}
}
