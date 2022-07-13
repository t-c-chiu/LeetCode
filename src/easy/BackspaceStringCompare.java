package easy;

public class BackspaceStringCompare {
	
	public static void main(String[] args) {
		System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
		
	}
	
	public static boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1, j = t.length() - 1;
		while (true) {
			int skip = 0;
			while (i >= 0 && (s.charAt(i) == '#' || skip > 0)) {
				skip += s.charAt(i) == '#' ? 1 : -1;
				i--;
			}
			skip = 0;
			while (j >= 0 && (t.charAt(j) == '#' || skip > 0)) {
				skip += t.charAt(j) == '#' ? 1 : -1;
				j--;
			}
			if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
				i--;
				j--;
			} else {
				break;
			}
		}
		return i == -1 && j == -1;
	}

//	public static boolean backspaceCompare(String s, String t) {
//		Stack<Character> st1 = new Stack<>(), st2 = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (c != '#') {
//				st1.push(c);
//			} else if (!st1.isEmpty()) {
//				st1.pop();
//			}
//		}
//		for (int i = 0; i < t.length(); i++) {
//			char c = t.charAt(i);
//			if (c != '#') {
//				st2.push(c);
//			} else if (!st2.isEmpty()) {
//				st2.pop();
//			}
//		}
//		while (!st1.isEmpty() && !st2.isEmpty()) {
//			if (st1.pop() != st2.pop()) {
//				return false;
//			}
//		}
//		return st1.isEmpty() && st2.isEmpty();
//	}
}
