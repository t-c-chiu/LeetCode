package hard;

import java.util.TreeMap;

public class MyCalendarIII {
	
	public static void main(String[] args) {
		MyCalendarThree myCalendarThree = new MyCalendarThree();
		myCalendarThree.book(10, 20); // return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
		myCalendarThree.book(50, 60); // return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
		myCalendarThree.book(10, 40); // return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2-booking.
		myCalendarThree.book(5, 15); // return 3, The remaining events cause the maximum K-booking to be only a 3-booking.
		myCalendarThree.book(5, 10); // return 3
		myCalendarThree.book(25, 55); // return 3
	}
	
	static class MyCalendarThree {
		
		TreeMap<Integer, Integer> map;
		
		public MyCalendarThree() {
			map = new TreeMap<>();
		}
		
		public int book(int start, int end) {
			map.put(start, map.getOrDefault(start, 0) + 1);
			map.put(end, map.getOrDefault(end, 0) - 1);
			int max = 0, event = 0;
			for (Integer count : map.values()) {
				event += count;
				max = Math.max(max, event);
			}
			return max;
		}
	}
}
