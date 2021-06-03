package hard;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		int res = trap(new int[]{4, 2, 3});
		System.out.println(res);
	}
	
	public static int trap(int[] height) {
		int length = height.length;
		if (length < 3) {
			return 0;
		}
		
		int[] leftHighestIdx = new int[length];
		leftHighestIdx[0] = 0;
		for (int i = 1; i < length; i++) {
			if (height[i - 1] >= height[leftHighestIdx[i - 1]]) {
				leftHighestIdx[i] = i - 1;
			} else {
				leftHighestIdx[i] = leftHighestIdx[i - 1];
			}
		}
		int[] rightHighestIdx = new int[length];
		rightHighestIdx[length - 1] = length - 1;
		for (int i = length - 2; i >= 0; i--) {
			if (height[i + 1] >= height[rightHighestIdx[i + 1]]) {
				rightHighestIdx[i] = i + 1;
			} else {
				rightHighestIdx[i] = rightHighestIdx[i + 1];
			}
		}
		int highest = 0;
		for (int i = 1; i < length; i++) {
			if (height[i] > height[highest]) {
				highest = i;
			}
		}
		return trapLeftWater(highest, height, leftHighestIdx) + trapRightWater(highest, height, rightHighestIdx);
	}
	
	private static int trapLeftWater(int highest, int[] height, int[] leftHighestIdx) {
		int leftHighest = leftHighestIdx[highest];
		if (highest == leftHighest) {
			return 0;
		}
		
		int sum = 0;
		for (int i = leftHighest + 1; i < highest; i++) {
			sum += height[leftHighest] - height[i];
		}
		return sum + trapLeftWater(leftHighest, height, leftHighestIdx);
	}
	
	private static int trapRightWater(int highest, int[] height, int[] rightHighestIdx) {
		int rightHighest = rightHighestIdx[highest];
		if (highest == rightHighest) {
			return 0;
		}
		
		int sum = 0;
		for (int i = highest + 1; i < rightHighest; i++) {
			sum += height[rightHighest] - height[i];
		}
		return sum + trapRightWater(rightHighest, height, rightHighestIdx);
	}
	
}
