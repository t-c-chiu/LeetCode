package hard;

import java.util.HashSet;
import java.util.Set;

public class ShortestImpossibleSequenceOfRolls {
	
	public static void main(String[] args) {
		int res = shortestSequence(new int[]{4, 2, 1, 2, 3, 3, 2, 4, 1}, 4);
		System.out.println(res);
	}
	
	public static int shortestSequence(int[] rolls, int k) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int i : rolls) {
			set.add(i);
			if (set.size() == k) {
				res++;
				set.clear();
			}
		}
		return res + 1;
	}
}
