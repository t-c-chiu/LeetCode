package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RangeModule {
	
	public static void main(String[] args) {
		RangeModule rangeModule = new RangeModule();
		rangeModule.addRange(10, 20);
		rangeModule.removeRange(14, 16);
		System.out.println(rangeModule.queryRange(10, 14)); // return True,(Every number in [10, 14) is being tracked)
		System.out.println(rangeModule.queryRange(13, 15)); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
		System.out.println(rangeModule.queryRange(16, 17)); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
	}
	
	TreeMap<Integer, Integer> map;
	
	public RangeModule() {
		map = new TreeMap<>();
	}
	
	public void addRange(int left, int right) {
		while (map.floorKey(right) != null) {
			int preLeft = map.floorKey(right);
			int preRight = map.get(preLeft);
			if (preRight < left) {
				break;
			}
			left = Math.min(left, preLeft);
			right = Math.max(right, preRight);
			map.remove(preLeft);
		}
		map.put(left, right);
	}
	
	public boolean queryRange(int left, int right) {
		if (map.floorKey(right) == null) {
			return false;
		}
		int preLeft = map.floorKey(right);
		int preRight = map.get(preLeft);
		return preLeft <= left && preRight >= right;
	}
	
	public void removeRange(int left, int right) {
		Map<Integer, Integer> addedRange = new HashMap<>();
		while (map.floorKey(right) != null) {
			int preLeft = map.floorKey(right);
			int preRight = map.get(preLeft);
			if (preRight < left) {
				break;
			}
			map.remove(preLeft);
			if (preRight > right) {
				addedRange.put(right, preRight);
			}
			if (preLeft < left) {
				addedRange.put(preLeft, left);
			}
		}
		map.putAll(addedRange);
	}
}
