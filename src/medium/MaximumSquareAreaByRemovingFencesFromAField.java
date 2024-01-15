package medium;

import java.util.*;

public class MaximumSquareAreaByRemovingFencesFromAField {
	
	public static void main(String[] args) {
		int res = maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2});
		System.out.println(res);
	}
	
	public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
		List<Integer> hList = new ArrayList<>();
		hList.add(1);
		hList.add(m);
		for (int hFence : hFences) {
			hList.add(hFence);
		}
		List<Integer> vList = new ArrayList<>();
		vList.add(1);
		vList.add(n);
		for (int vFence : vFences) {
			vList.add(vFence);
		}
		Set<Long> diff = new HashSet<>();
		for (int i = 0; i < hList.size(); i++) {
			for (int j = 0; j < hList.size(); j++) {
				if (i != j) {
					diff.add(Math.abs((long) hList.get(i) - hList.get(j)));
				}
			}
		}
		long side = 0;
		int modulo = (int) 1e9 + 7;
		for (int i = 0; i < vList.size(); i++) {
			for (int j = 0; j < vList.size(); j++) {
				if (i != j) {
					long d = Math.abs((long) vList.get(i) - vList.get(j));
					if (diff.contains(d)) {
						side = Math.max(side, d);
					}
				}
			}
		}
		return side == 0 ? -1 : (int) (side * side % modulo);
	}
	
}
