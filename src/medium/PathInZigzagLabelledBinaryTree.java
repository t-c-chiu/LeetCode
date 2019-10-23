package medium;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
	
	public static void main(String[] args) {
		PathInZigzagLabelledBinaryTree test = new PathInZigzagLabelledBinaryTree();
		test.pathInZigZagTree(14).forEach(System.out::println);
	}
	
	//
	//         1
	//     2       3
	//   4   5   6   7
	//  8 9 A B C D E F
	//
	//         1
	//     3       2
	//   4   5   6   7
	//  F E D C B A 9 8
	//
	//  1 3 4 14
	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> res = new ArrayList<>();
		int level = 0;
		while (label > 0) {
			res.add(0, label);
			label /= 2;
			level++;
		}
		
		boolean swap = false;
		while (level > 1) {
			if (swap) {
				int low = (int) Math.pow(2, level - 1), high = (int) Math.pow(2, level) - 1;
				res.add(level - 1, low + high - res.remove(level - 1));
			}
			swap = !swap;
			level--;
		}
		return res;
	}
}
