package hard;

import util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
	
	public static void main(String[] args) {
		List<Interval> res = employeeFreeTime(Arrays.asList(
				Interval.generateIntervals(new int[][]{{1, 2}, {5, 6}}),
				Interval.generateIntervals(new int[][]{{1, 3}}),
				Interval.generateIntervals(new int[][]{{4, 10}})
		));
		System.out.println(res);
	}
	
	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> res = new ArrayList<>();
		List<Interval> intervals = new ArrayList<>();
		for (List<Interval> list : schedule) {
			intervals.addAll(list);
		}
		intervals.sort(Comparator.comparingInt(o -> o.start));
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				res.add(new Interval(end, interval.start));
				end = interval.end;
			}
		}
		return res;
	}
}
