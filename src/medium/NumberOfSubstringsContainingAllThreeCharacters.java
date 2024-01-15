package medium;

public class NumberOfSubstringsContainingAllThreeCharacters {
	
	public static void main(String[] args) {
		int res = numberOfSubstrings("abcabc");
		System.out.println(res);
	}
	
	public static int numberOfSubstrings(String s) {
		int count[] = {0, 0, 0}, res = 0, n = s.length();
		for (int lo = 0, hi = 0; hi < n; ++hi) {
			count[s.charAt(hi) - 'a']++;
			while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
				res += n - hi;
				count[s.charAt(lo++) - 'a']--;
			}
		}
		return res;
	}
}
