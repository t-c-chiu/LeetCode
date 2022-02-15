package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
	
	public static void main(String[] args) {
		int res = maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10);
		System.out.println(res);
	}
	
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		int res = 0;
		int[] count = new int[1001];
		for (int[] boxType : boxTypes) {
			count[boxType[1]] += boxType[0];
		}
		for (int i = 1000; i >= 1 && truckSize > 0; i--) {
			if (count[i] > 0) {
				int boxes = Math.min(truckSize, count[i]);
				res += boxes * i;
				truckSize -= boxes;
			}
		}
		return res;
	}

//	public static int maximumUnits(int[][] boxTypes, int truckSize) {
//		Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
//		int res = 0, i = 0;
//		while (truckSize > 0 && i < boxTypes.length) {
//			if (truckSize >= boxTypes[i][0]) {
//				res += boxTypes[i][0] * boxTypes[i][1];
//				truckSize -= boxTypes[i][0];
//			} else {
//				res += truckSize * boxTypes[i][1];
//				break;
//			}
//			i++;
//		}
//		return res;
//	}
}
