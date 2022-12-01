package medium;

import java.util.*;

public class MyCalendarII {
	
	public static void main(String[] args) {
		MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
		myCalendarTwo.book(10, 20); // return True, The event can be booked.
		myCalendarTwo.book(50, 60); // return True, The event can be booked.
		myCalendarTwo.book(10, 40); // return True, The event can be double booked.
		myCalendarTwo.book(5, 15);  // return False, The event cannot be booked,
		// because it would result in a triple booking.
		myCalendarTwo.book(5, 10); // return True, The event can be booked,
		// as it does not use time 10 which is already double booked.
		myCalendarTwo.book(25, 55); // return True, The event can be booked,
		// as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
	}
	
	static class MyCalendarTwo {
		
		List<int[]> books;
		List<int[]> doubleBooks;
		
		public MyCalendarTwo() {
			books = new ArrayList<>();
			doubleBooks = new ArrayList<>();
		}
		
		public boolean book(int start, int end) {
			for (int[] doubleBook : doubleBooks) {
				if (start < doubleBook[1] && end > doubleBook[0]) {
					return false;
				}
			}
			for (int[] book : books) {
				if (start < book[1] && end > book[0]) {
					doubleBooks.add(new int[]{Math.max(start, book[0]), Math.min(end, book[1])});
				}
			}
			books.add(new int[]{start, end});
			return true;
		}
	}
	
}
