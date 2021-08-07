package medium;

public class ShortestWayToFormString {
	
	public static void main(String[] args) {
		int res = shortestWay("xyz", "xzyxz");
		System.out.println(res);
	}
	
	public static int shortestWay(String source, String target) {
		int res = 0;
		int i = 0;
		while (i < target.length()) {
			int oldI = i;
			for (int j = 0; i < target.length() && j < source.length(); j++) {
				if (target.charAt(i) == source.charAt(j)) {
					i++;
				}
			}
			if (i == oldI) {
				return -1;
			}
			res++;
		}
		return res;
	}
}
