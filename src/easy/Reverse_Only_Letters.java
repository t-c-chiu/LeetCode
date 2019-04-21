package easy;

public class Reverse_Only_Letters {
	
	public static void main(String[] args) {
		Reverse_Only_Letters test = new Reverse_Only_Letters();
		System.out.println(test.reverseOnlyLetters("ab-cd"));
		System.out.println(test.reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(test.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}
	
	public String reverseOnlyLetters(String S) {
		char[] chars = S.toCharArray();
		int i = 0, j = chars.length - 1;
		while (i < j) {
			while (i < j && !Character.isLetter(chars[i]))
				i++;
			while (i < j && !Character.isLetter(chars[j]))
				j--;
			if (i < j) {
				char tmp = chars[i];
				chars[i++] = chars[j];
				chars[j--] = tmp;
			}
		}
		return String.valueOf(chars);
	}
}
