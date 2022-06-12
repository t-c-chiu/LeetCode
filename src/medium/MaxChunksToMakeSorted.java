package medium;

public class MaxChunksToMakeSorted {
	
	public static void main(String[] args) {
		int res = maxChunksToSorted(new int[]{4, 3, 2, 1, 0});
		System.out.println(res);
	}
	
	public static int maxChunksToSorted(int[] arr) {
		int res = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if (max == i) {
				res++;
			}
		}
		return res;
	}
}
