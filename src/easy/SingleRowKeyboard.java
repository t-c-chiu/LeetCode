package easy;

public class SingleRowKeyboard {
	
	public static void main(String[] args) {
		int res = calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode");
		System.out.println(res);
	}
	
	public static int calculateTime(String keyboard, String word) {
		int[] pos = new int[26];
		for (int i = 0; i < keyboard.length(); i++) {
			pos[keyboard.charAt(i) - 'a'] = i;
		}
		int res = 0, prev = 0;
		for (int i = 0; i < word.length(); i++) {
			int j = pos[word.charAt(i) - 'a'];
			res += Math.abs(j - prev);
			prev = j;
		}
		return res;
	}
	
}
