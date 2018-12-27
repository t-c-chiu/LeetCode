package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

	public static void main(String[] args) {
		UncommonWordsFromTwoSentences uncommonWordsFromTwoSentences = new UncommonWordsFromTwoSentences();
		for (String string : uncommonWordsFromTwoSentences.uncommonFromSentences(
				"this apple is sweet", "this apple is sour"))
			System.out.println(string);

		for (String string : uncommonWordsFromTwoSentences.uncommonFromSentences(
				"apple apple", "banana"))
			System.out.println(string);
	}

	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> map = new HashMap<>();
		for (String string : A.split(" "))
			map.put(string, map.getOrDefault(string, 0) + 1);
		for (String string : B.split(" "))
			map.put(string, map.getOrDefault(string, 0) + 1);
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				result.add(entry.getKey());
		}
		return result.toArray(new String[result.size()]);
	}
}
