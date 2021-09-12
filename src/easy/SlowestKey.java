package easy;

public class SlowestKey {
	
	public static void main(String[] args) {
		char res = slowestKey(new int[]{12, 23, 36, 46, 62}, "spudb");
		System.out.println(res);
	}
	
	public static char slowestKey(int[] releaseTimes, String keysPressed) {
		int max = releaseTimes[0];
		char res = keysPressed.charAt(0);
		for (int i = 1; i < releaseTimes.length; i++) {
			char c = keysPressed.charAt(i);
			int duration = releaseTimes[i] - releaseTimes[i - 1];
			if (duration > max || duration == max && c > res) {
				max = duration;
				res = c;
			}
		}
		return res;
	}
}
