package hard;

public class ThreeEqualParts {
	
	public static void main(String[] args) {
		int[] res = threeEqualParts(new int[]{1, 1, 0, 0, 1});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] threeEqualParts(int[] arr) {
		int ones = 0;
		for (int i : arr) {
			if (i == 1) {
				ones++;
			}
		}
		int n = arr.length;
		if (ones == 0) {
			return new int[]{0, n - 1};
		}
		if (ones % 3 != 0) {
			return new int[]{-1, -1};
		}
		
		int k = ones / 3;
		int count = 0;
		int start = 0;
		int mid = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				count++;
				if (count == 1) {
					start = i;
				} else if (count == k + 1) {
					mid = i;
				} else if (count == 2 * k + 1) {
					end = i;
				}
			}
		}
		
		while (end < n && arr[start] == arr[mid] && arr[mid] == arr[end]) {
			start++;
			mid++;
			end++;
		}
		if (end == n) {
			return new int[]{start - 1, mid};
		}
		
		return new int[]{-1, -1};
	}
}
