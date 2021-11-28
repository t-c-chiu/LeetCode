package medium;

public class ShortestWordDistanceIII {
	
	public static void main(String[] args) {
		int res = shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes");
		System.out.println(res);
	}
	
	public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
		int prev = -1, n = wordsDict.length, res = n;
		boolean isSame = word1.equals(word2);
		for (int i = 0; i < n; i++) {
			String word = wordsDict[i];
			if (word.equals(word1) || word.equals(word2)) {
				if (prev != -1 && (isSame || !word.equals(wordsDict[prev]))) {
					res = Math.min(res, i - prev);
				}
				prev = i;
			}
		}
		return res;
	}
//	public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
//		int idx1 = -1, idx2 = -1, res = Integer.MAX_VALUE;
//		boolean isSame = word1.equals(word2);
//		for (int i = 0; i < wordsDict.length; i++) {
//			if (wordsDict[i].equals(word1)) {
//				if (isSame) {
//					idx1 = idx2;
//					idx2 = i;
//				} else {
//					idx1 = i;
//				}
//			} else if (wordsDict[i].equals(word2)) {
//				idx2 = i;
//			}
//			if (idx1 != -1 && idx2 != -1) {
//				res = Math.min(res, Math.abs(idx1 - idx2));
//			}
//		}
//		return res;
//	}
}
