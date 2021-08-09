package medium;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
	
	public static void main(String[] args) {
		int res = minSwaps("][][");
		System.out.println(res);
	}
	
	public static int minSwaps(String s) {
		int open = 0;
		int misMatch = 0;
		for (char c : s.toCharArray()) {
			open += c == '[' ? 1 : -1;
			misMatch = Math.min(misMatch, open);
		}
		return (-misMatch + 1) / 2;
	}

//	public static int minSwaps(String s) {
//		int res = 0;
//		char[] chars = s.toCharArray();
//		int left = 0;
//		int leftDiff = 0;
//		int right = s.length() - 1;
//		int rightDiff = 0;
//		while (left < right) {
//			while (left < right && leftDiff >= 0) {
//				leftDiff += chars[left++] == '[' ? 1 : -1;
//			}
//			while (left < right && rightDiff >= 0) {
//				rightDiff += chars[right--] == ']' ? 1 : -1;
//			}
//			if (leftDiff == -1) {
//				res++;
//				leftDiff = rightDiff = 1;
//			}
//		}
//		return res;
//	}
}
