package easy;

public class KthMissingPositiveNumber {
	
	public static void main(String[] args) {
		int res = findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
		System.out.println(res);
	}
	
	public static int findKthPositive(int[] arr, int k) {
		int lo = 0, hi = arr.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] - mid - 1 < k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo + k;
	}
	
}
