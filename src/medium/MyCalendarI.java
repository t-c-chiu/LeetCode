package medium;

import java.util.TreeMap;

public class MyCalendarI {
	
	public static void main(String[] args) {
		MyCalendar myCalendar = new MyCalendar();
		boolean res = myCalendar.book(10, 20);// return True
		System.out.println(res);
		res = myCalendar.book(15, 25); // return False,
		// It can not be booked because time 15 is already booked by another event.
		System.out.println(res);
		res = myCalendar.book(20, 30); // return True,
		// The event can be booked, as the first event takes every time less than 20, but not including 20.
		System.out.println(res);
	}
	
	static class MyCalendar {
		
		TreeMap<Integer, Integer> map;
		
		public MyCalendar() {
			map = new TreeMap<>();
		}
		
		public boolean book(int start, int end) {
			Integer preStart = map.lowerKey(end);
			if (preStart == null || map.get(preStart) <= start) {
				map.put(start, end);
				return true;
			}
			return false;
		}
	}
}
