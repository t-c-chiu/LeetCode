package medium;

import java.util.List;

public class ZigzagIterator {
	
	public static void main(String[] args) {
	
	}
	
	int i, j;
	List<Integer> v1, v2;
	boolean v1Turn;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
		v1Turn = true;
	}
	
	public int next() {
		if (!hasNext()) {
			return -1;
		}
		if (i == v1.size()) {
			return v2.get(j++);
		} else if (j == v2.size()) {
			return v1.get(i++);
		}
		int res = v1Turn ? v1.get(i++) : v2.get(j++);
		v1Turn = !v1Turn;
		return res;
	}
	
	public boolean hasNext() {
		return i < v1.size() || j < v2.size();
	}
}
