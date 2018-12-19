package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static void main(String[] args) {
		System.out.println(new FizzBuzz().fizzBuzz(15));
	}
	
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			StringBuilder builder = new StringBuilder();
			if (i % 3 == 0)
				builder.append("Fizz");
			if (i % 5 == 0)
				builder.append("Buzz");
			if (builder.length() == 0)
				builder.append(String.valueOf(i));
			result.add(builder.toString());
		}
		return result;
	}
}
