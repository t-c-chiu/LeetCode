package hard;

public class MinimumNumberOfMovesToMakePalindrome {
	
	public static void main(String[] args) {
		int res = minMovesToMakePalindrome("letelt");
		System.out.println(res);
	}
	
	public static int minMovesToMakePalindrome(String s) {
		int left = 0, right = s.length() - 1, res = 0;
		char[] chars = s.toCharArray();
		while (left < right) {
			int i = right;
			while (chars[left] != chars[i]) {
				i--;
			}
			if (left == i) {
				swap(chars, left, left + 1);
				res++;
			} else {
				while (i < right) {
					swap(chars, i, i + 1);
					res++;
					i++;
				}
				left++;
				right--;
			}
		}
		return res;
	}
	
	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
