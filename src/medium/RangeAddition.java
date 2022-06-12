package medium;

public class RangeAddition {
	
	public static void main(String[] args) {
		int[] res = getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];
		for (int[] update : updates) {
			res[update[0]] += update[2];
			if (update[1] < length - 1) {
				res[update[1] + 1] -= update[2];
			}
		}
		
		for (int i = 1; i < res.length; i++) {
			res[i] += res[i - 1];
		}
		return res;
	}
}
