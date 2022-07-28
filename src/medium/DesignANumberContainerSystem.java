package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignANumberContainerSystem {
	
	public static void main(String[] args) {
		NumberContainers nc = new NumberContainers();
		nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
		nc.change(2, 10); // Your container at index 2 will be filled with number 10.
		nc.change(1, 10); // Your container at index 1 will be filled with number 10.
		nc.change(3, 10); // Your container at index 3 will be filled with number 10.
		nc.change(5, 10); // Your container at index 5 will be filled with number 10.
		nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
		nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
		nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
	}
	
	static class NumberContainers {
		
		Map<Integer, Integer> indexToNum;
		Map<Integer, TreeSet<Integer>> numToIndices;
		
		public NumberContainers() {
			indexToNum = new HashMap<>();
			numToIndices = new HashMap<>();
		}
		
		public void change(int index, int number) {
			Integer oldNum = indexToNum.get(index);
			if (oldNum != null) {
				numToIndices.get(oldNum).remove(index);
			}
			indexToNum.put(index, number);
			numToIndices.putIfAbsent(number, new TreeSet<>());
			numToIndices.get(number).add(index);
		}
		
		public int find(int number) {
			TreeSet<Integer> indices = numToIndices.get(number);
			if (indices == null || indices.isEmpty()) {
				return -1;
			}
			return indices.first();
		}
	}
}
