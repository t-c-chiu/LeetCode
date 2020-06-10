package medium;

import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers {
	
	public static void main(String[] args) {
		Lexicographical_Numbers test = new Lexicographical_Numbers();
		List<Integer> res = test.lexicalOrder(13);
		System.out.println(res);
	}
	
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			lexicalOrder(n, res, i);
		}
		return res;
	}
	
	private void lexicalOrder(int n, List<Integer> res, int num) {
		if (num > n) {
			return;
		}
		res.add(num);
		for (int i = 0; i < 10; i++) {
			int nextNum = num * 10 + i;
			if (nextNum > n) {
				return;
			}
			lexicalOrder(n, res, nextNum);
		}
	}
}
