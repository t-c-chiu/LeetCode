package util;

import java.util.ArrayList;
import java.util.List;

public class Interval {
	public int start;
	public int end;
	
	public Interval() {
	}
	
	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
	
	public static List<Interval> generateIntervals(int[][] intervals) {
		List<Interval> list = new ArrayList<>();
		for (int[] interval : intervals) {
			list.add(new Interval(interval[0], interval[1]));
		}
		return list;
	}
	
	@Override
	public String toString() {
		return "Interval{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}
