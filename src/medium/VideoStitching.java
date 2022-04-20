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
		int start = 0;
		int count = 0;
		int i = 0;
		while (start < time) {
			count++;
			int newStart = start;
			while (i < clips.length && clips[i][0] <= start) {
				newStart = Math.max(newStart, clips[i][1]);
				if (newStart >= time) {
					return count;
				}
				i++;
			}
			if (start == newStart) {
				return -1;
			}
			start = newStart;
		}
		return count;
	}
	
}
