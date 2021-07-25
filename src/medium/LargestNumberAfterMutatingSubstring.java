package medium;

public class LargestNumberAfterMutatingSubstring {
	
	public static void main(String[] args) {
		String res = maximumNumber("214010", new int[]{6, 7, 9, 7, 4, 0, 3, 4, 4, 7});
		System.out.println(res);
	}
	
	public static String maximumNumber(String num, int[] change) {
		int i = 0;
		int n = num.length();
		char[] chars = num.toCharArray();
		while (i < n && chars[i] - '0' >= change[chars[i] - '0']) {
			i++;
		}
		while (i < n && chars[i] - '0' <= change[chars[i] - '0']) {
			chars[i] = (char) (change[chars[i] - '0'] + '0');
			i++;
		}
		return new String(chars);
	}
}
