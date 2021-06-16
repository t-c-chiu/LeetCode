package medium;

public class MinimumAdjacentSwapsToReachTheKthSmallestNumber {
	
	public static void main(String[] args) {
		int res = getMinSwaps("99499", 1);
		System.out.println(res);
	}
	
	public static int getMinSwaps(String num, int k) {
		char[] oldNum = num.toCharArray();
		char[] newNum = getNext(num.toCharArray(), k);
		int n = num.length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (oldNum[i] != newNum[i]) {
				for (int j = i + 1; j < n; j++) {
					if (oldNum[i] == newNum[j]) {
						res += j - i;
						while (j > i) {
							swap(newNum, j - 1, j);
							j--;
						}
						break;
					}
				}
			}
		}
		return res;
	}
	
	
	private static char[] getNext(char[] num, int k) {
		if (k == 1) {
			int len = num.length;
			int i = len - 1;
			while (num[i - 1] >= num[i]) {
				i--;
			}
			
			int swapIdx = i;
			int numToSwap = num[i - 1];
			for (int j = i; j < len; j++) {
				int tmp = num[j];
				if (tmp > numToSwap && tmp <= num[swapIdx]) {
					swapIdx = j;
				}
			}
			swap(num, i - 1, swapIdx);
			reverse(num, i);
			return num;
		} else {
			return getNext(getNext(num, k - 1), 1);
		}
	}
	
	private static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static void reverse(char[] arr, int i) {
		int j = arr.length - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}
}
