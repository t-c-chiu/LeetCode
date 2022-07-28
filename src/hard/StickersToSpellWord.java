package hard;

import java.util.HashMap;
import java.util.Map;

public class StickersToSpellWord {
	
	public static void main(String[] args) {
		int res = minStickers(new String[]{"with", "example", "science"}, "thehat");
		System.out.println(res);
	}
	
	public static int minStickers(String[] stickers, String target) {
		int m = stickers.length;
		int[][] count = new int[m][26];
		for (int i = 0; i < stickers.length; i++) {
			String sticker = stickers[i];
			for (int j = 0; j < sticker.length(); j++) {
				count[i][sticker.charAt(j) - 'a']++;
			}
		}
		Map<String, Integer> dp = new HashMap<>();
		dp.put("", 0);
		return helper(dp, count, target);
	}
	
	private static int helper(Map<String, Integer> dp, int[][] stickersCount, String target) {
		if (dp.containsKey(target)) {
			return dp.get(target);
		}
		int res = Integer.MAX_VALUE;
		int[] targetCount = new int[26];
		for (int i = 0; i < target.length(); i++) {
			targetCount[target.charAt(i) - 'a']++;
		}
		for (int[] stickerCount : stickersCount) {
			if (stickerCount[target.charAt(0) - 'a'] == 0) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				if (targetCount[i] > 0) {
					for (int j = 0; j < Math.max(0, targetCount[i] - stickerCount[i]); j++) {
						sb.append((char) (i + 'a'));
					}
				}
			}
			String next = sb.toString();
			int temp = helper(dp, stickersCount, next);
			if (temp != -1) {
				res = Math.min(res, temp + 1);
			}
		}
		dp.put(target, res == Integer.MAX_VALUE ? -1 : res);
		return dp.get(target);
	}
}
