package medium;

public class DeleteAndEarn {
	
	public static void main(String[] args) {
		int res = deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
		System.out.println(res);
	}
	
	public static int deleteAndEarn(int[] nums) {
		int[] sum = new int[10001];
		for (int num : nums) {
			sum[num] += num;
		}
		int preTake = 0, preSkip = 0;
		for (int i = 1; i < sum.length; i++) {
			int take = preSkip + sum[i];
			int skip = Math.max(preSkip, preTake);
			preTake = take;
			preSkip = skip;
		}
		return Math.max(preTake, preSkip);
	}
}
