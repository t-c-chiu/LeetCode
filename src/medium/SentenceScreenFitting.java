package medium;

public class SentenceScreenFitting {
	
	public static void main(String[] args) {
		int res = wordsTyping(new String[]{"i", "had", "apple", "pie"}, 4, 5);
		System.out.println(res);
	}
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		int n = sentence.length;
		int[] count = new int[n];
		int[] nextWord = new int[n];
		for (int i = 0; i < n; i++) {
			int curIndex = i;
			int len = 0;
			int sentenceCount = 0;
			while (len + sentence[curIndex].length() <= cols) {
				len += sentence[curIndex].length() + 1;
				curIndex++;
				if (curIndex == n) {
					sentenceCount++;
					curIndex = 0;
				}
			}
			count[i] = sentenceCount;
			nextWord[i] = curIndex;
		}
		int res = 0;
		int curWord = 0;
		for (int i = 0; i < rows; i++) {
			res += count[curWord];
			curWord = nextWord[curWord];
		}
		return res;
	}
	
}
