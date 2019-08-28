package medium;

import java.util.TreeMap;

public class MyCalendarI {
	
	public static void main(String[] args) {
		MyCalendar calendar = new MyCalendarI().new MyCalendar();
		System.out.println(calendar.book(10, 20));
		System.out.println(calendar.book(5, 15));
		System.out.println(calendar.book(15, 25));
		System.out.println(calendar.book(20, 30));
	}
	
	class MyCalendar {
		
		private TreeMap<Integer, Integer> map = new TreeMap<>();
		
		public MyCalendar() {
		
		}
		
		public boolean book(int start, int end) {
			final Integer lowerKey = map.lowerKey(end);
			if (lowerKey == null || map.get(lowerKey) <= start) {
				map.put(start, end);
				return true;
			}
			return false;
		}
	}
}
