package medium;

public class PeakIndexInAMountainArray {
	
	public static void main(String[] args) {
		int res = peakIndexInMountainArray(new int[]{0, 1, 0});
		System.out.println(res);
	}
	
	public static int peakIndexInMountainArray(int[] arr) {
		int n = arr.length, lo = 0, hi = n;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] < arr[mid + 1]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
