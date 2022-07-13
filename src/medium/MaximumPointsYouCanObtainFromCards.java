package medium;

public class MaximumPointsYouCanObtainFromCards {
	
	public static void main(String[] args) {
		int res = maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
		System.out.println(res);
	}
	
	public static int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length, leftSum = 0, rightSum = 0;
		for (int i = 0; i < k; i++) {
			leftSum += cardPoints[i];
		}
		int res = leftSum;
		for (int i = 0; i < k; i++) {
			leftSum -= cardPoints[k - i - 1];
			rightSum += cardPoints[n - i - 1];
			res = Math.max(res, leftSum + rightSum);
		}
		return res;
	}

//	public static int maxScore(int[] cardPoints, int k) {
//		int n = cardPoints.length, res = 0;
//		int[] arr = new int[k * 2];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = cardPoints[(n - k + i) % n];
//		}
//		for (int right = 0, left = 0, score = 0; right < arr.length; right++) {
//			score += arr[right];
//			if (right - left == k) {
//				score -= arr[left++];
//			}
//			res = Math.max(res, score);
//		}
//		return res;
//	}
}
