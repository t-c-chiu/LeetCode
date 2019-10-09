package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
	
	public static void main(String[] args) {
		AllPossibleFullBinaryTrees test = new AllPossibleFullBinaryTrees();
		test.allPossibleFBT(7).forEach(System.out::println);
	}
	
	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> res = new ArrayList<>();
		if (N % 2 == 0)
			return res;
		if (N == 1) {
			res.add(new TreeNode(0));
			return res;
		}
		// 所有tree的總結點一定是奇數(N) 子節點相加一定是偶數
		// 先拆分子節點可能的數量分配 例如總節點假設有5個 子節點總數就是4個
		// 可能是左1右3或左3右1 先產出所有的子節點排列組合後再逐一生成父節點
		// 而產生左3或右3的時候 又可以遞迴地產生左1右1
		for (int leftNum = 1; leftNum < N; leftNum += 2) {
			List<TreeNode> leftNodes = allPossibleFBT(leftNum);
			List<TreeNode> rightNodes = allPossibleFBT(N - leftNum - 1);
			for (TreeNode left : leftNodes) {
				for (TreeNode right : rightNodes) {
					TreeNode cur = new TreeNode(0);
					cur.left = left;
					cur.right = right;
					res.add(cur);
				}
			}
		}
		return res;
	}
}
