package medium;

import java.util.TreeSet;

public class FindLatestGroupOfSizeM {
	
	public static void main(String[] args) {
		int res = findLatestStep(new int[]{3, 5, 1, 2, 4}, 1);
		System.out.println(res);
	}
	
	public static int findLatestStep(int[] arr, int m) {
		int n = arr.length;
		if (n == m) {
			return n;
		}
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(0);
		treeSet.add(n + 1);
		for (int i = n - 1; i >= 0; i--) {
			int index = arr[i];
			int leftZero = treeSet.floor(index);
			int rightZero = treeSet.ceiling(index);
			if (index - leftZero - 1 == m || rightZero - index - 1 == m) {
				return i;
			}
			treeSet.add(index);
		}
		return -1;
	}
}
