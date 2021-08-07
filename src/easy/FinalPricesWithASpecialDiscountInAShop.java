package easy;

import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {
	
	public static void main(String[] args) {
		int[] res = finalPrices(new int[]{1, 2, 3, 2, 3, 4, 1, 2, 3, 2, 1, 2, 1});
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static int[] finalPrices(int[] prices) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
				prices[stack.pop()] -= prices[i];
			}
			stack.push(i);
		}
		return prices;
	}

//	public static int[] finalPrices(int[] prices) {
//		for (int i = 0; i < prices.length; i++) {
//			for (int j = i + 1; j < prices.length; j++) {
//				if (prices[j] <= prices[i]) {
//					prices[i] -= prices[j];
//					break;
//				}
//			}
//		}
//		return prices;
//	}
}
