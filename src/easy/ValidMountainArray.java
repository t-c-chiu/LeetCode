package easy;

public class ValidMountainArray {
	
	public static void main(String[] args) {
		boolean res = validMountainArray(new int[]{0, 3, 2, 1});
		System.out.println(res);
	}
	
	public static boolean validMountainArray(int[] arr) {
		int n = arr.length;
		int l = 0, r = n - 1;
		while (l + 1 < n && arr[l + 1] > arr[l]) {
			l++;
		}
		while (r - 1 > 0 && arr[r - 1] > arr[r]) {
			r--;
		}
		return l > 0 && r < n - 1 && l == r;
	}
}
