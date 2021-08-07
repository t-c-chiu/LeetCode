package medium;

public class SumOfBeautyOfAllSubstrings {
	
	public static void main(String[] args) {
		int res = beautySum("aabcb");
		System.out.println(res);
	}
	
	public static int beautySum(String s) {
		int n = s.length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			int count[] = new int[26];
			int max = 0;
			for (int j = i; j < n; j++) {
				int k = s.charAt(j) - 'a';
				count[k]++;
				max = Math.max(max, count[k]);
				int min = getMin(count);
				res += max - min;
			}
		}
		return res;
	}
	
	private static int getMin(int[] count) {
		int min = Integer.MAX_VALUE;
		for (int i : count) {
			if (i > 0) {
				min = Math.min(min, i);
			}
		}
		return min;
	}
}
