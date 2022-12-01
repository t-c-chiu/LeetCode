package medium;

import java.util.TreeMap;

public class SnapshotArray {
	
	public static void main(String[] args) {
		SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
		snapshotArr.set(0, 5);  // Set array[0] = 5
		snapshotArr.snap();  // Take a snapshot, return snap_id = 0
		snapshotArr.set(0, 6);
		System.out.println(snapshotArr.get(0, 0));  // Get the value of array[0] with snap_id = 0, return 5
	}
	
	int snap;
	TreeMap<Integer, Integer>[] maps;
	
	public SnapshotArray(int length) {
		maps = new TreeMap[length];
		for (int i = 0; i < length; i++) {
			maps[i] = new TreeMap<>();
			maps[i].put(snap, 0);
		}
	}
	
	public void set(int index, int val) {
		maps[index].put(snap, val);
	}
	
	public int snap() {
		return snap++;
	}
	
	public int get(int index, int snap_id) {
		return maps[index].floorEntry(snap_id).getValue();
	}
}
