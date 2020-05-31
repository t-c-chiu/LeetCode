package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shortest_Distance_to_a_Character {
	
	public static void main(String[] args) {
		Shortest_Distance_to_a_Character test = new Shortest_Distance_to_a_Character();
		for (int i : test.shortestToChar2("loveleetcode", 'e')) {
			System.out.print(i);
		}
	}
	
	public int[] shortestToChar(String S, char C) {
		int len = S.length();
		int[] result = new int[len];
		Arrays.fill(result, Integer.MAX_VALUE);
		List<Integer> charPos = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (S.charAt(i) == C)
				charPos.add(i);
		}
		for (int i = 0; i < len; i++) {
			for (int j : charPos)
				result[i] = Math.min(result[i], Math.abs(i - j));
		}
		return result;
	}
	
	public int[] shortestToChar2(String S, char C) {
		int len = S.length();
		int pos = -len;
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			if (S.charAt(i) == C) pos = i;
			result[i] = Math.abs(i - pos);
		}
		for (int i = len - 1; i >= 0; i--) {
			if (S.charAt(i) == C) pos = i;
			result[i] = Math.min(result[i], Math.abs(i - pos));
		}
		return result;
	}
}
