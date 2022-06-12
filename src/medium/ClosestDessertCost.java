package medium;

public class ClosestDessertCost {
	
	public static void main(String[] args) {
		int res = closestCost(new int[]{3, 10}, new int[]{2, 5}, 9);
		System.out.println(res);
	}
	
	static int res;
	
	public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		res = baseCosts[0];
		for (int baseCost : baseCosts) {
			backtrack(baseCost, toppingCosts, 0, target);
		}
		return res;
	}
	
	private static void backtrack(int current, int[] toppingCosts, int index, int target) {
		if (Math.abs(current - target) < Math.abs(res - target) || Math.abs(current - target) == Math.abs(res - target) && current < res) {
			res = current;
		}
		if (index == toppingCosts.length || current >= target) {
			return;
		}
		backtrack(current, toppingCosts, index + 1, target);
		backtrack(current + toppingCosts[index], toppingCosts, index + 1, target);
		backtrack(current + toppingCosts[index] * 2, toppingCosts, index + 1, target);
	}
}
