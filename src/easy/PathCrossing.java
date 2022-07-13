package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
	
	public static void main(String[] args) {
		boolean res = isPathCrossing("NESWW");
		System.out.println(res);
	}
	
	public static boolean isPathCrossing(String path) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int x = 0, y = 0;
		map.put(x, new HashSet<>());
		map.get(x).add(y);
		for (int i = 0; i < path.length(); i++) {
			switch (path.charAt(i)) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
			}
			if (!map.computeIfAbsent(x, k -> new HashSet<>()).add(y)) {
				return true;
			}
		}
		return false;
	}
}
