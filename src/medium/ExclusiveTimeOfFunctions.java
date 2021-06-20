package medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExclusiveTimeOfFunctions {
	
	public static void main(String[] args) {
		int[] res = exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	public static int[] exclusiveTime(int n, List<String> logs) {
		List<Log> list = logs.stream().map(s -> {
			String[] log = s.split(":");
			return new Log(Integer.parseInt(log[0]), log[1].equals("start"), Integer.parseInt(log[2]));
		}).collect(Collectors.toList());
		
		int[] res = new int[n];
		Stack<Log> stack = new Stack<>();
		int preTime = 0;
		for (Log log : list) {
			if (log.start) {
				if (!stack.isEmpty()) {
					res[stack.peek().id] += log.time - preTime;
				}
				stack.push(log);
				preTime = log.time;
			} else {
				Log startLog = stack.pop();
				res[startLog.id] += log.time - preTime + 1;
				preTime = log.time + 1;
			}
		}
		return res;
	}
	
	static class Log {
		int id;
		boolean start;
		int time;
		
		public Log(int id, boolean start, int time) {
			this.id = id;
			this.start = start;
			this.time = time;
		}
	}
}
