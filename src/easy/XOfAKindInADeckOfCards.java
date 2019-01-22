package easy;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {
	public static void main(String[] args) {
		XOfAKindInADeckOfCards xOfAKindInADeckOfCards = new XOfAKindInADeckOfCards();
//		System.out.println(xOfAKindInADeckOfCards.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
		System.out.println(xOfAKindInADeckOfCards.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
//		System.out.println(xOfAKindInADeckOfCards.hasGroupsSizeX(new int[]{1}));
//		System.out.println(xOfAKindInADeckOfCards.hasGroupsSizeX(new int[]{1, 1}));
//		System.out.println(xOfAKindInADeckOfCards.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
	}

	public boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> count = new HashMap<>();
		int gcd = 0;
		for (int i : deck)
			count.put(i, count.getOrDefault(i, 0) + 1);
		for (int i : count.values())
			gcd = gcd(i, gcd);
		return gcd > 1;
	}

	public int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}
}
