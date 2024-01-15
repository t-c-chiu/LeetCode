package medium;

public class MinimumInsertionsToBalanceAParenthesesString {
	
	public static void main(String[] args) {
//		int res = minInsertions("))())(");
		int res = minInsertions("()())))()");
		System.out.println(res);
	}
	
	public static int minInsertions(String s) {
		int needRight = 0, added = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				if (needRight % 2 == 1) {
					needRight--;
					added++;
				}
				needRight += 2;
			} else {
				if (needRight == 0) {
					added++;
					needRight = 1;
				} else {
					needRight--;
				}
			}
		}
		return needRight + added;
	}

//	public static int minInsertions(String s) {
//		int res = 0;
//		Stack<Integer> stack = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (c == '(') {
//				if (!stack.isEmpty() && stack.peek() != 2) {
//					stack.pop();
//					res++;
//				}
//				stack.push(2);
//			} else {
//				if (stack.isEmpty()) {
//					res++;
//					stack.push(1);
//				} else if (stack.peek() == 2) {
//					stack.pop();
//					stack.push(1);
//				} else if (stack.peek() == 1) {
//					stack.pop();
//				}
//			}
//		}
//		for (Integer i : stack) {
//			res += i;
//		}
//		return res;
//	}
}
