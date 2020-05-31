package medium;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		GroupAnagrams test = new GroupAnagrams();
		final List<List<String>> ans =
				test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println(ans);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = new String(chars);
			if (!map.containsKey(sortedStr))
				map.put(sortedStr, new ArrayList<>());
			map.get(sortedStr).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
