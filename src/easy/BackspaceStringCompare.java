package easy;

public class BackspaceStringCompare {
	
	public static void main(String[] args) {
		BackspaceStringCompare test = new BackspaceStringCompare();
		System.out.println(test.backspaceCompare("ab#c", "ad#c"));
		System.out.println(test.backspaceCompare("ab##", "c#d#"));
		System.out.println(test.backspaceCompare("a##c", "#a#c"));
		System.out.println(test.backspaceCompare("a#c", "b"));
		
	}
	
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		while (true) {
			for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); i--)
				back += S.charAt(i) == '#' ? 1 : -1;
			for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); j--)
				back += T.charAt(j) == '#' ? 1 : -1;
			if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
				i--;
				j--;
			} else
				return i == -1 && j == -1;
		}
	}
	
	private String modify(String string) {
		int index = 0;
		while (index < string.length()) {
			if (string.charAt(index) == '#') {
				if (index == 0)
					string = string.substring(index + 1);
				else
					string = string.substring(0, index - 1) + string.substring(index + 1);
				index = 0;
			} else
				index++;
		}
		return string;
	}
}
