package medium;

import java.util.TreeMap;

public class SnapshotArray {
	
	int version;
	TreeMap<Integer, Integer>[] arr;
	
	public SnapshotArray(int length) {
		arr = new TreeMap[length];
	}
	
	public void set(int index, int val) {
		if (arr[index] == null) {
			arr[index] = new TreeMap<>();
		}
		arr[index].put(version, val);
	}
	
	public int snap() {
		return version++;
	}
	
	public int get(int index, int snap_id) {
		if (arr[index] == null || arr[index].floorEntry(snap_id) == null) {
			return 0;
		}
		return arr[index].floorEntry(snap_id).getValue();
	}
}
