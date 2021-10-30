package medium;

import java.util.*;

public class AdvantageShuffle {
	
	public static void main(String[] args) {
		int[] res = advantageCount(new int[]{718967141, 189971378, 341560426, 23521218, 339517772},
				new int[]{967482459, 978798455, 744530040, 3454610, 940238504});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] advantageCount(int[] nums1, int[] nums2) {
		int n = nums1.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
		for (int i = 0; i < n; i++) {
			pq.offer(new int[]{nums2[i], i});
		}
		Arrays.sort(nums1);
		int[] res = new int[n];
		int left = 0, right = n - 1;
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			res[poll[1]] = nums1[right] > poll[0] ? nums1[right--] : nums1[left++];
		}
		return res;
	}

//	public static int[] advantageCount(int[] nums1, int[] nums2) {
//		int n = nums1.length;
//		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//		for (int i = 0; i < n; i++) {
//			pq.offer(new int[]{nums2[i], i});
//		}
//
//		Arrays.sort(nums1);
//		int[] res = new int[n];
//		List<Integer> remain = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			if (nums1[i] > pq.peek()[0]) {
//				res[pq.poll()[1]] = nums1[i];
//			} else {
//				remain.add(nums1[i]);
//			}
//		}
//		while (!pq.isEmpty()) {
//			res[pq.poll()[1]] = remain.remove(0);
//		}
//		return res;
//	}
	
}
