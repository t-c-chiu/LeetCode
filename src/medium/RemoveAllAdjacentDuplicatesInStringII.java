package medium;

public class RemoveAllAdjacentDuplicatesInStringII {
	
	public static void main(String[] args) {
		String res = removeDuplicates("deeedbbcccbdaa", 3);
		System.out.println(res);
	}
	
	public static String removeDuplicates(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int[] count = new int[n];
		for (char c : s.toCharArray()) {
			sb.append(c);
			int last = sb.length() - 1;
			if (sb.length() > 1 && sb.charAt(last) == sb.charAt(last - 1)) {
				count[last] = count[last - 1] + 1;
				if (count[last] == k) {
					sb.delete(sb.length() - k, sb.length());
				}
			} else {
				count[last] = 1;
			}
		}
		return sb.toString();
	}
//	public static String removeDuplicates(String s, int k) {
//		Stack<int[]> stack = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (stack.isEmpty()) {
//				stack.push(new int[]{c, 1});
//				continue;
//			}
//			int[] peek = stack.peek();
//			if (peek[0] == c && peek[1] + 1 == k) {
//				stack.pop();
//			} else if (peek[0] == c) {
//				peek[1]++;
//			} else {
//				stack.push(new int[]{c, 1});
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for (int[] info : stack) {
//			sb.append(String.valueOf((char) (info[0])).repeat(info[1]));
//		}
//		return sb.toString();
//	}
}
