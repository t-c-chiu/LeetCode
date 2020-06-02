package medium;

public class Binary_Subarrays_With_Sum {
	
	public static void main(String[] args) {
		Binary_Subarrays_With_Sum test = new Binary_Subarrays_With_Sum();
		int res = test.numSubarraysWithSum(new int[]{0, 0, 1, 0, 1, 0, 1, 1, 0}, 2);
		System.out.println(res);
	}
	
	public int numSubarraysWithSum(int[] A, int S) {
		int res = 0, zero = 0, sum = 0, left = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			while (sum > S && left < i) {
				zero = 0;
				sum -= A[left++];
			}
			if (sum == S) {
				while (left < i && A[left] == 0) {
					left++;
					zero++;
				}
				res += zero + 1;
			}
		}
		return res;
	}
}
