package medium;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		int res = maxArea(new int[]{1, 3, 2, 5, 25, 24, 5});
		System.out.println(res);
	}
	
	public static int maxArea(int[] height) {
		int res = 0, l = 0, r = height.length - 1;
		while (l < r) {
			res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
}
