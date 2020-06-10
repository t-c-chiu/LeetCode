package medium;

import java.util.TreeMap;

public class Snapshot_Array {
	
	public static void main(String[] args) {
		SnapshotArray test = new Snapshot_Array().new SnapshotArray(3);
		test.set(0, 5);
		System.out.println(test.snap());
		test.set(0, 6);
		System.out.println(test.get(0, 0));
		System.out.println(test.snap());
		System.out.println(test.get(0, 1));
	}
	
	class SnapshotArray {
		
		int snapId;
		TreeMap<Integer, Integer>[] map;
		
		public SnapshotArray(int length) {
			snapId = 0;
			map = new TreeMap[length];
			for (int i = 0; i < length; i++) {
				TreeMap<Integer, Integer> treeMap = new TreeMap<>();
				treeMap.put(snapId, 0);
				map[i] = treeMap;
			}
		}
		
		public void set(int index, int val) {
			map[index].put(snapId, val);
		}
		
		public int snap() {
			return snapId++;
		}
		
		public int get(int index, int snap_id) {
			return map[index].floorEntry(snap_id).getValue();
		}
	}
}
