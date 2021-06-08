package medium;

import java.util.Arrays;

public class PutBoxesIntoTheWarehouseI {
	
	public static void main(String[] args) {
		int res = maxBoxesInWarehouse(new int[]{4, 5, 6}, new int[]{1, 2, 3, 4});
		System.out.println(res);
	}
	
	public static int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
		Arrays.sort(boxes);
		int n = warehouse.length;
		for (int i = 1; i < warehouse.length; i++) {
			warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
		}
		
		int pos = n - 1;
		int res = 0;
		while (res < boxes.length && pos >= 0) {
			if (boxes[res] <= warehouse[pos]) {
				res++;
			}
			pos--;
		}
		return res;
	}
}
