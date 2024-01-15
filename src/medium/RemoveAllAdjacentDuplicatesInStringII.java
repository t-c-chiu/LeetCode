package medium;

public class RemoveAllAdjacentDuplicatesInStringII {
	
	public static void main(String[] args) {
		String res = removeDuplicates("deeedbbcccbdaa", 3);
		System.out.println(res);
	}
	
	public static String removeDuplicates(String s, int k) {
		StringBuilder builder = new StringBuilder();
		int[] count = new int[s.length()];
		for (char c : s.toCharArray()) {
			builder.append(c);
			int last = builder.length() - 1;
			if (builder.length() > 1 && builder.charAt(last) == builder.charAt(last - 1)) {
				count[last] = count[last - 1] + 1;
				if (count[last] == k) {
					builder.delete(last - k + 1, last + 1);
				}
			} else {
				count[last] = 1;
			}
		}
		return builder.toString();
	}

//	public static String removeDuplicates(String s, int k) {
//		Stack<int[]> stack = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (stack.isEmpty() || stack.peek()[0] != c) {
//				stack.push(new int[]{c, 1});
//			} else {
//				int count = stack.peek()[1];
//				if (count + 1 == k) {
//					stack.pop();
//				} else {
//					stack.peek()[1]++;
//				}
//			}
//		}
//		StringBuilder builder = new StringBuilder();
//		for (int[] info : stack) {
//			builder.append(String.valueOf((char) info[0]).repeat(info[1]));
//		}
//		return builder.toString();
//	}
}
