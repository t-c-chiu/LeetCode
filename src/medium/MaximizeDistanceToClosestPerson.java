package medium;

public class MaximizeDistanceToClosestPerson {
	
	public static void main(String[] args) {
		int res = maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
		System.out.println(res);
	}
	
	public static int maxDistToClosest(int[] seats) {
		int n = seats.length, res = 0, lastPerson = -1;
		int[] distance = new int[n];
		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				lastPerson = i;
			}
			distance[i] = lastPerson == -1 ? Integer.MAX_VALUE : i - lastPerson;
		}
		lastPerson = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				lastPerson = i;
			}
			if (lastPerson != -1) {
				distance[i] = Math.min(distance[i], lastPerson - i);
			}
			res = Math.max(res, distance[i]);
		}
		return res;
	}
}
