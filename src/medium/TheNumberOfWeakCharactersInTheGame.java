package medium;

import java.util.*;

public class TheNumberOfWeakCharactersInTheGame {
	
	public static void main(String[] args) {
		int res = numberOfWeakCharacters(new int[][]{
				{10, 1},
				{5, 1},
				{7, 10},
				{4, 1},
				{5, 9},
				{6, 9},
				{7, 2},
				{1, 10},
		});
		System.out.println(res);
	}
	
	public static int numberOfWeakCharacters(int[][] properties) {
		Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		int maxDefense = 0, res = 0;
		for (int[] property : properties) {
			if (maxDefense > property[1]) {
				res++;
			}
			maxDefense = Math.max(maxDefense, property[1]);
		}
		return res;
	}
}
