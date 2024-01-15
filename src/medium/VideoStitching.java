package medium;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
	
	public static void main(String[] args) {
		int res = new VideoStitching().videoStitching(new int[][]{
				{0, 2},
				{4, 6},
				{8, 10},
				{1, 9},
				{1, 5},
				{5, 9}
		}, 10);
		System.out.println(res);
	}
	
	public int videoStitching(int[][] clips, int time) {
		Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
		int i = 0, start = 0, count = 0, n = clips.length;
		while (i < n) {
			count++;
			int nextStart = start;
			while (i < n && clips[i][0] <= start) {
				nextStart = Math.max(nextStart, clips[i][1]);
				if (nextStart >= time) {
					return count;
				}
				i++;
			}
			if (nextStart == start) {
				return -1;
			}
			start = nextStart;
		}
		return -1;
	}
	
}
