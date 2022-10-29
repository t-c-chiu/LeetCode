package medium;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		int res = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
		System.out.println(res);
	}
	
	public static int maxArea(int[] height) {
		int res = 0, left = 0, right = height.length - 1;
		while (left < right) {
			res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
}
