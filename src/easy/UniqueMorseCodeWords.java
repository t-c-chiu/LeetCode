package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
	private static String[] morseCodeTable = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
	
	public static void main(String[] args) {
		System.out.println(new UniqueMorseCodeWords().morseCodeTable(new String[]{"gin", "zen", "gig", "msg"}));
	}
	
	public int morseCodeTable(String[] words) {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			StringBuilder stringBuilder = new StringBuilder();
			for (char c : word.toCharArray()) {
				stringBuilder.append(morseCodeTable[c - 'a']);
			}
			result.add(stringBuilder.toString());
		}
		return result.size();
	}
}
