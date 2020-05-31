package medium;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
	
	public static void main(String[] args) {
		LetterTilePossibilities test = new LetterTilePossibilities();
		int ans = test.numTilePossibilities("AAB");
		System.out.println(ans);
		ans = test.numTilePossibilities("AAABBC");
		System.out.println(ans);
	}
	
	public int numTilePossibilities(String tiles) {
		Set<String> set = new HashSet<>();
		backtrack(set, new boolean[tiles.length()], new StringBuilder(), tiles);
		return set.size();
	}
	
	private void backtrack(Set<String> set, boolean[] visited, StringBuilder builder, String tiles) {
		if (builder.length() > 0)
			set.add(builder.toString());
		
		for (int i = 0; i < tiles.length(); i++) {
			if (visited[i])
				continue;
			builder.append(tiles.charAt(i));
			visited[i] = true;
			backtrack(set, visited, builder, tiles);
			builder.setLength(builder.length() - 1);
			visited[i] = false;
		}
	}
}
