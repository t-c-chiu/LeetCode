package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
	
	public static void main(String[] args) {
	
	}
	
	public static void findSecretWord(String[] words, Master master) {
		List<String> candidates = Arrays.stream(words).toList();
		Random random = new Random();
		while (true) {
			String guess = candidates.get(random.nextInt(candidates.size()));
			int match = master.guess(guess);
			if (match == 6) {
				return;
			}
			List<String> newCandidates = new ArrayList<>();
			for (String candidate : candidates) {
				if (matchChars(guess, candidate) == match) {
					newCandidates.add(candidate);
				}
			}
			candidates = newCandidates;
		}
	}
	
	private static int matchChars(String s1, String s2) {
		int match = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				match++;
			}
		}
		return match;
	}
	
	interface Master {
		int guess(String word);
	}
}
