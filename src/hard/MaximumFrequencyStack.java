package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
	
	public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
		freqStack.push(5); // The stack is [5]
		freqStack.push(7); // The stack is [5,7]
		freqStack.push(5); // The stack is [5,7,5]
		freqStack.push(7); // The stack is [5,7,5,7]
		freqStack.push(4); // The stack is [5,7,5,7,4]
		freqStack.push(5); // The stack is [5,7,5,7,4,5]
		freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
		freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
		freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
		freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
	}
	
	static class FreqStack {
		
		Map<Integer, Integer> valToFreq = new HashMap<>();
		Map<Integer, Stack<Integer>> freqToStack = new HashMap<>();
		int maxFreq = 0;
		
		public FreqStack() {
		
		}
		
		public void push(int val) {
			valToFreq.put(val, valToFreq.getOrDefault(val, 0) + 1);
			int freq = valToFreq.get(val);
			freqToStack.putIfAbsent(freq, new Stack<>());
			freqToStack.get(freq).push(val);
			maxFreq = Math.max(maxFreq, freq);
		}
		
		public int pop() {
			Stack<Integer> stack = freqToStack.get(maxFreq);
			int val = stack.pop();
			valToFreq.put(val, valToFreq.get(val) - 1);
			if (stack.isEmpty()) {
				maxFreq--;
			}
			return val;
		}
	}
	
}
