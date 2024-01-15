package hard;

public class PathSumIV {
	
	public static void main(String[] args) {
		int res = pathSum(new int[]{113, 215, 221});
		System.out.println(res);
	}
	
	public static int pathSum(int[] nums) {
		int res = 0;
		int[][] sum = new int[5][9];
		for (int num : nums) {
			int level = num / 100, pos = num / 10 % 10, val = num % 10;
			sum[level][pos] = val + sum[level - 1][(pos + 1) / 2];
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 9; j++) {
				if (i == 4 || sum[i][j] != 0 && sum[i + 1][j * 2 - 1] == 0 && sum[i + 1][j * 2] == 0) {
					res += sum[i][j];
				}
			}
		}
		return res;
	}

//	static int res = 0;

//	public static int pathSum(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int num : nums) {
//			int key = num / 10, val = num % 10;
//			map.put(key, val);
//		}
//		dfs(nums[0] / 10, map, 0);
//		return res;
//	}
//
//	private static void dfs(int key, Map<Integer, Integer> map, int sum) {
//		if (!map.containsKey(key)) {
//			return;
//		}
//		int level = key / 10, pos = key % 10, val = map.get(key);
//		sum += val;
//		int left = (level + 1) * 10 + pos * 2 - 1;
//		int right = left + 1;
//		if (!map.containsKey(left) && !map.containsKey(right)) {
//			res += sum;
//			return;
//		}
//		dfs(left, map, sum);
//		dfs(right, map, sum);
//	}
	
}
