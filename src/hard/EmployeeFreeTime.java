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
		List<Interval> intervals = new ArrayList<>();
		for (List<Interval> list : schedule) {
			intervals.addAll(list);
		}
		intervals.sort(Comparator.comparingInt(o -> o.start));
		List<Interval> res = new ArrayList<>();
		Interval cur = intervals.get(0);
		for (Interval interval : intervals) {
			if (cur.end >= interval.start) {
				cur.end = Math.max(cur.end, interval.end);
			} else {
				res.add(new Interval(cur.end, interval.start));
				cur = interval;
			}
		}
		return res;
	}
}
