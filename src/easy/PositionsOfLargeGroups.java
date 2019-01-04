package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {
	public static void main(String[] args) {
		PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();
		// [[3,6]]
		System.out.println(positionsOfLargeGroups.largeGroupPositions("abbxxxxzzy"));
		// []
		System.out.println(positionsOfLargeGroups.largeGroupPositions("abc"));
		// [[3,5],[6,9],[12,14]]
		System.out.println(positionsOfLargeGroups.largeGroupPositions("abcdddeeeeaabbbcd"));
	}

	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();
		int start = 0, end = 0, length = S.length();
		while (end < length) {
			while (end < length && S.charAt(start) == S.charAt(end))
				end++;
			if (end - start >= 3)
				result.add(Arrays.asList(start, end - 1));
			start = end;
		}
		return result;
	}
}
