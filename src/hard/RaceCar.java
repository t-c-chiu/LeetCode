package hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar {
	
	public static void main(String[] args) {
		int res = racecar(3);
		System.out.println(res);
	}
	
	public static int racecar(int target) {
		Set<String> seen = new HashSet<>();
		Queue<int[]> queue = new LinkedList<>();
		int res = 0;
		seen.add(0 + "," + 1);
		queue.offer(new int[]{0, 1});
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int[] poll = queue.poll();
				int pos = poll[0];
				int speed = poll[1];
				if (pos == target) {
					return res;
				}
				int[] accelerate = new int[]{pos + speed, speed * 2};
				String key = accelerate[0] + "," + accelerate[1];
				if (!seen.contains(key) && Math.abs(accelerate[0] - target) < target) {
					seen.add(key);
					queue.offer(accelerate);
				}
				int[] reverse = new int[]{pos, speed > 0 ? -1 : 1};
				key = reverse[0] + "," + reverse[1];
				if (!seen.contains(key)) {
					seen.add(key);
					queue.offer(reverse);
				}
			}
			res++;
		}
		return -1;
	}
}
