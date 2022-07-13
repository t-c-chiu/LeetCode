package medium;

public class ThreeSumWithMultiplicity {
	
	public static void main(String[] args) {
		int res = threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
		System.out.println(res);
	}
	
	public static int threeSumMulti(int[] arr, int target) {
		long res = 0;
		long[] count = new long[101];
		for (int i : arr) {
			count[i]++;
		}
		for (int i = 0; i < 101; i++) {
			for (int j = i; j < 101; j++) {
				int k = target - i - j;
				if (k < 0 || k > 100) {
					continue;
				}
				if (i == j && j == k) {
					res += count[i] * (count[j] - 1) * (count[k] - 2) / 6;
				} else if (i == j) {
					res += count[i] * (count[j] - 1) / 2 * count[k];
				} else if (j < k) {
					res += count[i] * count[j] * count[k];
				}
			}
		}
		return (int) (res % (1e9 + 7));
	}
//	public static int threeSumMulti(int[] arr, int target) {
//		int res = 0, mod = (int) (1e9 + 7);
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < arr.length; i++) {
//			res = (res + map.getOrDefault(target - arr[i], 0)) % mod;
//			for (int j = 0; j < i; j++) {
//				int sum = arr[i] + arr[j];
//				map.put(sum, map.getOrDefault(sum, 0) + 1);
//			}
//		}
//		return res;
//	}
}
