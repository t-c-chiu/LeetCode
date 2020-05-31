package medium;

public class TaskScheduler {
	
	public static void main(String[] args) {
		TaskScheduler test = new TaskScheduler();
		int res = test.leastInterval(
				new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E', 'E'}, 5);
		System.out.println(res);
	}
	
	// n = 3, partCount = 2, emptySlot = 2, availableTasks = 4, idles = 0
	// A B C _ A B C _ A B C
	// A B C D E A B C D E A B C
	//
	// n = 5, partCount = 2, emptySlot = 6, availableTasks = 4, idles = 2
	// A B C _ _ _ A B C _ _ _ A B C
	// A B C D E _ A B C D E _ A B C
	public int leastInterval(char[] tasks, int n) {
		int[] counter = new int[26];
		int max = 0, maxCount = 0;
		for (char task : tasks) {
			int c = task - 'A';
			counter[c]++;
			if (max == counter[c])
				maxCount++;
			else if (max < counter[c]) {
				max = counter[c];
				maxCount = 1;
			}
		}
		
		int partCount = max - 1;
		int partLength = n - (maxCount - 1);
		int emptySlot = partCount * partLength;
		int availableTasks = tasks.length - max * maxCount;
		int idles = Math.max(0, emptySlot - availableTasks);
		return tasks.length + idles;
	}
}
