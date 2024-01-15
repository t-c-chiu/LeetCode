package medium;

public class SentenceScreenFitting {
	
	public static void main(String[] args) {
		int res = wordsTyping(new String[]{"i", "had", "apple", "pie"}, 4, 5);
		System.out.println(res);
	}
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		int res = 0, n = sentence.length;
		int[] count = new int[n];
		int[] nextStart = new int[n];
		for (int i = 0; i < n; i++) {
			int cur = i, len = 0, sentenceCount = 0;
			while (len + sentence[cur].length() <= cols) {
				len += sentence[cur].length() + 1;
				cur++;
				if (cur == n) {
					sentenceCount++;
					cur = 0;
				}
			}
			count[i] = sentenceCount;
			nextStart[i] = cur;
		}
		int start = 0;
		for (int i = 0; i < rows; i++) {
			res += count[start];
			start = nextStart[start];
		}
		return res;
	}
	
}
