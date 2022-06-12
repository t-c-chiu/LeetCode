package medium;

public class MinimumGardenPerimeterToCollectEnoughApples {
	
	public static void main(String[] args) {
		long res = minimumPerimeter(1000000000);
		System.out.println(res);
	}
	
	public static long minimumPerimeter(long neededApples) {
		long apples = 0;
		long i = 0;
		while (apples < neededApples) {
			i += 1;
			apples += i * 12;
			apples += ((i * 2 - 1) + (i + 1)) * ((i * 2 - 1) - (i + 1) + 1) / 2 * 8;
		}
		return i * 8;
	}
}
