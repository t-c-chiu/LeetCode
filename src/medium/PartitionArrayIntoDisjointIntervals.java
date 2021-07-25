package medium;

public class PartitionArrayIntoDisjointIntervals {
	
	public static void main(String[] args) {
		int res = partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12});
		System.out.println(res);
	}
	
	public static int partitionDisjoint(int[] A) {
		int leftMax = A[0];
		int max = A[0];
		int pos = 0;
		for (int i = 1; i < A.length; i++) {
			max = Math.max(max, A[i]);
			if (leftMax > A[i]) {
				leftMax = max;
				pos = i;
			}
		}
		return pos + 1;
	}
}
