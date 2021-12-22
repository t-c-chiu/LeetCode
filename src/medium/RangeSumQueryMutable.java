package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RangeSumQueryMutable {
	
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[]{1, 3, 5});
		numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
		numArray.update(1, 2);   // nums = [1, 2, 5]
		numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
	}
	
	static class NumArray {
		
		class SegmentTreeNode {
			int start;
			int end;
			SegmentTreeNode left;
			SegmentTreeNode right;
			int sum;
			
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
			} else {
				int mid = start + (end - start) / 2;
				node.left = buildTree(nums, start, mid);
				node.right = buildTree(nums, mid + 1, end);
				node.sum = node.left.sum + node.right.sum;
			}
			return node;
		}
		
		public void update(int index, int val) {
			update(root, index, val);
		}
		
		private void update(SegmentTreeNode node, int index, int val) {
			if (node.start == index && node.end == index) {
				node.sum = val;
			} else {
				int mid = node.start + (node.end - node.start) / 2;
				if (index <= mid) {
					update(node.left, index, val);
				} else {
					update(node.right, index, val);
				}
				node.sum = node.left.sum + node.right.sum;
			}
		}
		
		public int sumRange(int left, int right) {
			return sumRange(root, left, right);
		}
		
		private int sumRange(SegmentTreeNode node, int start, int end) {
			if (node.start == start && node.end == end) {
				return node.sum;
			}
			int mid = node.start + (node.end - node.start) / 2;
			if (end <= mid) {
				return sumRange(node.left, start, end);
			} else if (start > mid) {
				return sumRange(node.right, start, end);
			} else {
				return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
			}
		}
	}
}
