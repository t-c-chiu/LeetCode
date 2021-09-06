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
		int res = 0;
		Arrays.sort(properties, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
		int maxDefense = 0;
		for (int[] property : properties) {
			if (property[1] < maxDefense) {
				res++;
			}
			maxDefense = Math.max(maxDefense, property[1]);
		}
		return res;
	}
}
