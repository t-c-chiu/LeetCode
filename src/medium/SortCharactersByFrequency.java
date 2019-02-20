package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
		System.out.println(sortCharactersByFrequency.frequencySort("tree"));
		System.out.println(sortCharactersByFrequency.frequencySort("cccaaa"));
		System.out.println(sortCharactersByFrequency.frequencySort("Aabb"));
	}

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list = list.stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : list) {
			for (int i = 0; i < entry.getValue(); i++)
				builder.append(entry.getKey());
		}
		return builder.toString();
	}
}
