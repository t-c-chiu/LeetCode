package easy;

public class JewelsAndStones {
	public static void main(String[] args) {
		System.out.print(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
	}
	
	public int numJewelsInStones(String J, String S) {
		int count = 0;
		for (char c : S.toCharArray()) {
			if (J.indexOf(c) != -1)
				count++;
		}
		return count;
	}
}