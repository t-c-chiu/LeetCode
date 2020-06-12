package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class All_Elements_in_Two_Binary_Search_Trees {
	
	public static void main(String[] args) {
		All_Elements_in_Two_Binary_Search_Trees test = new All_Elements_in_Two_Binary_Search_Trees();
		List<Integer> res = test.getAllElements(TreeNode.generateRoot(new Integer[]{2, 1, 4}), TreeNode.generateRoot(new Integer[]{1, 0, 3}));
		System.out.println(res);
	}
	
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> t1Vals = new ArrayList<>();
		inOrder(root1, t1Vals);
		List<Integer> t2Vals = new ArrayList<>();
		inOrder(root2, t2Vals);
		
		List<Integer> res = new ArrayList<>();
		int p1 = 0, p2 = 0, t1Size = t1Vals.size(), t2Size = t2Vals.size();
		while (p1 < t1Size && p2 < t2Size) {
			Integer t1Val = t1Vals.get(p1);
			Integer t2Val = t2Vals.get(p2);
			if (t1Val < t2Val) {
				res.add(t1Val);
				p1++;
			} else {
				res.add(t2Val);
				p2++;
			}
		}
		if (p1 < t1Size) {
			res.addAll(t1Vals.subList(p1, t1Size));
		}
		if (p2 < t2Size) {
			res.addAll(t2Vals.subList(p2, t2Size));
		}
		
		return res;
	}
	
	private void inOrder(TreeNode root, List<Integer> vals) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left, vals);
		vals.add(root.val);
		inOrder(root.right, vals);
	}
}
