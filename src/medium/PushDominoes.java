package medium;

public class PushDominoes {
	
	public static void main(String[] args) {
		String res = pushDominoes(".L.R...LR..L..");
		System.out.println(res);
	}
	
	// LL.RR.LLRRLL..
	public static String pushDominoes(String dominoes) {
		char[] chars = dominoes.toCharArray();
		char pre = 'L';
		int preIdx = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == 'L') {
				if (pre == 'L') {
					pushLeft(chars, preIdx, i);
				} else {
					pushToMid(chars, preIdx, i);
				}
				pre = c;
				preIdx = i;
			} else if (c == 'R') {
				if (pre == 'R') {
					pushRight(chars, preIdx, i);
				}
				pre = c;
				preIdx = i;
			}
		}
		if (pre == 'R') {
			pushRight(chars, preIdx, chars.length - 1);
		}
		return new String(chars);
	}
	
	private static void pushRight(char[] chars, int start, int end) {
		for (int i = start; i <= end; i++) {
			chars[i] = 'R';
		}
	}
	
	private static void pushToMid(char[] chars, int left, int right) {
		while (left < right) {
			chars[left++] = 'R';
			chars[right--] = 'L';
		}
	}
	
	private static void pushLeft(char[] chars, int start, int end) {
		for (int i = start; i <= end; i++) {
			chars[i] = 'L';
		}
	}
	
}
