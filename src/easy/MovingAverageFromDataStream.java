package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
	
	public static void main(String[] args) {
		MovingAverage movingAverage = new MovingAverage(3);
		movingAverage.next(1); // return 1.0 = 1 / 1
		movingAverage.next(10); // return 5.5 = (1 + 10) / 2
		movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
		movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
	}
	
	static class MovingAverage {
		
		int size;
		int sum;
		Queue<Integer> queue;
		
		public MovingAverage(int size) {
			this.size = size;
			sum = 0;
			queue = new LinkedList<>();
		}
		
		public double next(int val) {
			sum += val;
			queue.offer(val);
			if (queue.size() > size) {
				sum -= queue.poll();
			}
			return (double) sum / queue.size();
		}
	}
	
}
