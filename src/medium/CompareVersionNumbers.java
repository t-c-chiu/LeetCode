package medium;

public class CompareVersionNumbers {
	
	public static void main(String[] args) {
		int res = compareVersion("1.01", "1.0001");
		System.out.println(res);
	}
	
	public static int compareVersion(String version1, String version2) {
		String[] v1Arr = version1.split("\\.");
		String[] v2Arr = version2.split("\\.");
		int i = 0, j = 0;
		while (i < v1Arr.length && j < v2Arr.length) {
			int v1 = Integer.parseInt(v1Arr[i]);
			int v2 = Integer.parseInt(v2Arr[j]);
			if (v1 < v2) {
				return -1;
			} else if (v1 > v2) {
				return 1;
			}
			i++;
			j++;
		}
		while (i < v1Arr.length) {
			if (Integer.parseInt(v1Arr[i]) > 0) {
				return 1;
			}
			i++;
		}
		while (j < v2Arr.length) {
			if (Integer.parseInt(v2Arr[j]) > 0) {
				return -1;
			}
			j++;
		}
		return 0;
	}
}
