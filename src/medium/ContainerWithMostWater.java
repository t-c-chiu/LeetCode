package medium;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		ContainerWithMostWater test = new ContainerWithMostWater();
		System.out.println(test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
	}
	
	public int maxArea(int[] height) {
		int max = 0, left = 0, right = height.length - 1;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;
	}
}
