package medium;

public class ShortestWayToFormString {
	
	public static void main(String[] args) {
		int res = shortestWay("abc", "abcbc");
		System.out.println(res);
	}
	
	public static int shortestWay(String source, String target) {
		int i = 0, n = target.length(), res = 0;
		while (i < n) {
			int lastI = i;
			for (int j = 0; j < source.length() && i < n; j++) {
				if (target.charAt(i) == source.charAt(j)) {
					i++;
				}
			}
			if (i == lastI) {
				return -1;
			}
			res++;
		}
		return res;
	}
}
