package medium;

public class TaskScheduler {
	
	public static void main(String[] args) {
		int res = leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
		System.out.println(res);
	}
	
	// n = 3, partCount = 2, emptySlot = 2, availableTasks = 4, idles = 0
	// A B C _ A B C _ A B C
	// A B C D E A B C D E A B C
	//
	// n = 5, partCount = 2, emptySlot = 6, availableTasks = 4, idles = 2
	// A B C _ _ _ A B C _ _ _ A B C
	// A B C D E _ A B C D E _ A B C
	public static int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		int max = 0, maxCount = 0;
		for (char c : tasks) {
			int i = c - 'A';
			count[i]++;
			if (count[i] > max) {
				max = count[i];
				maxCount = 1;
			} else if (count[i] == max) {
				maxCount++;
			}
		}
		int part = max - 1;
		int emptySlots = (n - maxCount + 1) * part;
		int remainingTasks = tasks.length - (max * maxCount);
		int idle = Math.max(0, emptySlots - remainingTasks);
		return tasks.length + idle;
	}
}
