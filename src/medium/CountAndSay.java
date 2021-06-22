package medium;

public class CountAndSay {
	
	public static void main(String[] args) {
		String res = countAndSay(30);
		System.out.println(res);
	}
	
	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		
		String prev = countAndSay(n - 1);
		StringBuilder builder = new StringBuilder();
		char cur = prev.charAt(0);
		int count = 1;
		for (int i = 1; i < prev.length(); i++) {
			char c = prev.charAt(i);
			if (c == cur) {
				count++;
			} else {
				builder.append(count).append(cur);
				cur = c;
				count = 1;
			}
		}
		return builder.append(count).append(cur).toString();
	}
}
