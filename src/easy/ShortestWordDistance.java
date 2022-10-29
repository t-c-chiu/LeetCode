package easy;

public class ShortestWordDistance {
	
	public static void main(String[] args) {
		int res = shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
		System.out.println(res);
	}
	
	public static int shortestDistance(String[] wordsDict, String word1, String word2) {
		int res = Integer.MAX_VALUE, index1 = -1, index2 = -1;
		for (int i = 0; i < wordsDict.length; i++) {
			if (wordsDict[i].equals(word1)) {
				index1 = i;
				if (index2 != -1) {
					res = Math.min(res, index1 - index2);
				}
			} else if (wordsDict[i].equals(word2)) {
				index2 = i;
				if (index1 != -1) {
					res = Math.min(res, index2 - index1);
				}
				
			}
		}
		return res;
	}
}
