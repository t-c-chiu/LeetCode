package easy;

public class FindWordsThatCanBeFormedByCharacters {
	public static void main(String[] args) {
		FindWordsThatCanBeFormedByCharacters test = new FindWordsThatCanBeFormedByCharacters();
		int ans = test.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
		System.out.println(ans);
		ans = test.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr");
		System.out.println(ans);
	}
	
	public int countCharacters(String[] words, String chars) {
		int ans = 0;
		int[] ch = new int[26];
		for (char c : chars.toCharArray()) {
			ch[c - 'a']++;
		}
		out:
		for (String word : words) {
			int[] tmp = ch.clone();
			for (char c : word.toCharArray()) {
				if (--tmp[c - 'a'] < 0)
					continue out;
			}
			ans += word.length();
		}
		return ans;
	}
}
